package io.jiogram.types;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A file to upload with a request, sent as part of a {@code multipart/form-data} body.
 * <p>
 * In the request JSON the file is replaced by an {@code attach://<name>} reference and the
 * content is sent as a separate part with that name. This works both for method parameters
 * (e.g. {@code sendPhoto.photo}) and for nested fields (e.g. {@code InputMediaPhoto.media}).
 */
@JsonSerialize(using = InputFile.Serializer.class)
public sealed interface InputFile permits InputFile.FromPath, InputFile.FromBytes {

    /**
     * Creates an upload from a file on disk; the file name is taken from the path.
     */
    static InputFile fromPath(Path path) {
        return new FromPath(path, path.getFileName().toString());
    }

    /**
     * Creates an upload from in-memory content.
     */
    static InputFile fromBytes(String filename, byte[] content) {
        return new FromBytes(filename, content);
    }

    /**
     * Returns the file name sent to Telegram.
     */
    String filename();

    record FromPath(Path path, String filename) implements InputFile {
        public FromPath {
            Objects.requireNonNull(path, "path must not be null");
            Objects.requireNonNull(filename, "filename must not be null");
            if (!Files.isRegularFile(path)) {
                throw new IllegalArgumentException("Not a regular file: " + path);
            }
        }
    }

    record FromBytes(String filename, byte[] content) implements InputFile {
        public FromBytes {
            Objects.requireNonNull(filename, "filename must not be null");
            Objects.requireNonNull(content, "content must not be null");
        }
    }

    /**
     * Collects the files referenced while serializing one request. A session passes an
     * instance as the {@link #ATTRIBUTE} serialization attribute and reads it afterwards.
     */
    final class Attachments {

        /** Serialization attribute key under which a session passes the collector. */
        public static final String ATTRIBUTE = Attachments.class.getName();

        private final Map<String, InputFile> files = new LinkedHashMap<>();

        String add(InputFile file) {
            String name = "file" + files.size();
            files.put(name, file);
            return name;
        }

        /**
         * Returns the collected files by attach name, in serialization order.
         */
        public Map<String, InputFile> files() {
            return Collections.unmodifiableMap(files);
        }

        public boolean isEmpty() {
            return files.isEmpty();
        }
    }

    /**
     * Writes {@code attach://<name>} and registers the file with the request's {@link Attachments}.
     */
    final class Serializer extends JsonSerializer<InputFile> {
        @Override
        public void serialize(InputFile value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            if (!(serializers.getAttribute(Attachments.ATTRIBUTE) instanceof Attachments attachments)) {
                throw JsonMappingException.from(serializers,
                    "InputFile can only be serialized by a TelegramSession that sends multipart requests");
            }
            gen.writeString("attach://" + attachments.add(value));
        }
    }
}
