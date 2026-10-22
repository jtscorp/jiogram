package io.jiogram.codegen;

import io.jiogram.codegen.model.FieldDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Renders Javadoc comments for generated sources from the schema's descriptions, with a link to
 * the type's or method's section of the Bot API documentation.
 */
final class Javadoc {

    static final String API_DOCS_URL = "https://core.telegram.org/bots/api#";

    /** Maximum length of a comment line, including the leading {@code " * "}. */
    private static final int WIDTH = 100;

    private Javadoc() {
    }

    /**
     * Renders a comment for a top-level declaration.
     *
     * @param description the schema description; its line breaks become {@code <br>}
     * @param parameters  documented as {@code @param}, by Java name; entries without a
     *                    description are left out
     * @param apiName     the type or method name in the Bot API, linked with {@code @see}; or
     *                    {@code null} for no link
     */
    static String render(String description, List<FieldDefinition> parameters, String apiName) {
        List<String> lines = new ArrayList<>();
        String[] paragraphs = description == null ? new String[0] : description.strip().split("\n");
        for (int i = 0; i < paragraphs.length; i++) {
            String paragraph = paragraphs[i].strip();
            if (paragraph.isEmpty()) {
                continue;
            }
            lines.addAll(wrap((i == 0 ? "" : "<br>") + escape(paragraph), "", ""));
        }
        List<String> tags = new ArrayList<>();
        for (FieldDefinition parameter : parameters) {
            String text = parameter.description() == null ? "" : parameter.description().strip();
            if (!text.isEmpty()) {
                tags.addAll(wrap(escape(text.replace('\n', ' ')), "@param " + parameter.javaName() + " ", "    "));
            }
        }
        if (apiName != null) {
            tags.add("@see <a href=\"" + API_DOCS_URL + apiName.toLowerCase(Locale.ROOT) + "\">" + apiName
                    + " in the Bot API</a>");
        }
        if (!lines.isEmpty() && !tags.isEmpty()) {
            lines.add("");
        }
        lines.addAll(tags);

        StringBuilder comment = new StringBuilder("/**\n");
        for (String line : lines) {
            comment.append(line.isEmpty() ? " *" : " * " + line).append('\n');
        }
        return comment.append(" */\n").toString();
    }

    /**
     * Makes schema text safe inside a Javadoc comment: HTML-escapes it, and escapes {@code @}
     * (tags), backslashes (Java reads {@code \}{@code u} escapes even in comments) and the comment
     * terminator.
     */
    static String escape(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("@", "&#64;")
                .replace("\\", "&#92;")
                .replace("*/", "*&#47;");
    }

    /** Word-wraps {@code prefix + text}; continuation lines start with {@code indent}. */
    private static List<String> wrap(String text, String prefix, String indent) {
        int width = WIDTH - " * ".length();
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder(prefix);
        boolean lineHasWord = false;
        for (String word : text.split(" +")) {
            if (lineHasWord && line.length() + 1 + word.length() > width) {
                lines.add(line.toString());
                line = new StringBuilder(indent);
                lineHasWord = false;
            }
            if (lineHasWord) {
                line.append(' ');
            }
            line.append(word);
            lineHasWord = true;
        }
        lines.add(line.toString());
        return lines;
    }
}
