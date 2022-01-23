package xenon.game;

@SuppressWarnings("ALL")
enum Color {
    //Color end string, color reset
    RESET("\033[0m"),

    // Regular Colors. Normal color, no bold, background color etc.
    @SuppressWarnings("unused") BLACK("\033[0;30m"),    // BLACK
    RED("\033[0;31m"),      // RED
    @SuppressWarnings("unused") GREEN("\033[0;32m"),    // GREEN
    @SuppressWarnings("unused") YELLOW("\033[0;33m"),   // YELLOW
    BLUE("\033[0;34m"),     // BLUE
    MAGENTA("\033[0;35m"),  // MAGENTA
    @SuppressWarnings("unused") CYAN("\033[0;36m"),     // CYAN
    @SuppressWarnings("unused") WHITE("\033[0;37m"),    // WHITE

    // Bold
    @SuppressWarnings("unused") BLACK_BOLD("\033[1;30m"),   // BLACK
    @SuppressWarnings("unused") RED_BOLD("\033[1;31m"),     // RED
    GREEN_BOLD("\033[1;32m"),   // GREEN
    @SuppressWarnings("unused") YELLOW_BOLD("\033[1;33m"),  // YELLOW
    @SuppressWarnings("unused") BLUE_BOLD("\033[1;34m"),    // BLUE
    @SuppressWarnings("unused") MAGENTA_BOLD("\033[1;35m"), // MAGENTA
    @SuppressWarnings("unused") CYAN_BOLD("\033[1;36m"),    // CYAN
    @SuppressWarnings("unused") WHITE_BOLD("\033[1;37m"),   // WHITE

    // Underline
    @SuppressWarnings("unused") BLACK_UNDERLINED("\033[4;30m"),     // BLACK
    @SuppressWarnings("unused") RED_UNDERLINED("\033[4;31m"),       // RED
    @SuppressWarnings("unused") GREEN_UNDERLINED("\033[4;32m"),     // GREEN
    @SuppressWarnings("unused") YELLOW_UNDERLINED("\033[4;33m"),    // YELLOW
    @SuppressWarnings("unused") BLUE_UNDERLINED("\033[4;34m"),      // BLUE
    @SuppressWarnings("unused") MAGENTA_UNDERLINED("\033[4;35m"),   // MAGENTA
    @SuppressWarnings("unused") CYAN_UNDERLINED("\033[4;36m"),      // CYAN
    @SuppressWarnings("unused") WHITE_UNDERLINED("\033[4;37m"),     // WHITE

    // Background
    @SuppressWarnings("unused") BLACK_BACKGROUND("\033[40m"),   // BLACK
    @SuppressWarnings("unused") RED_BACKGROUND("\033[41m"),     // RED
    @SuppressWarnings("unused") GREEN_BACKGROUND("\033[42m"),   // GREEN
    @SuppressWarnings("unused") YELLOW_BACKGROUND("\033[43m"),  // YELLOW
    @SuppressWarnings("unused") BLUE_BACKGROUND("\033[44m"),    // BLUE
    @SuppressWarnings("unused") MAGENTA_BACKGROUND("\033[45m"), // MAGENTA
    @SuppressWarnings("unused") CYAN_BACKGROUND("\033[46m"),    // CYAN
    @SuppressWarnings("unused") WHITE_BACKGROUND("\033[47m"),   // WHITE

    // High Intensity
    @SuppressWarnings("unused") BLACK_BRIGHT("\033[0;90m"),     // BLACK
    @SuppressWarnings("unused") RED_BRIGHT("\033[0;91m"),       // RED
    @SuppressWarnings("unused") GREEN_BRIGHT("\033[0;92m"),     // GREEN
    @SuppressWarnings("unused") YELLOW_BRIGHT("\033[0;93m"),    // YELLOW
    @SuppressWarnings("unused") BLUE_BRIGHT("\033[0;94m"),      // BLUE
    @SuppressWarnings("unused") MAGENTA_BRIGHT("\033[0;95m"),   // MAGENTA
    @SuppressWarnings("unused") CYAN_BRIGHT("\033[0;96m"),      // CYAN
    @SuppressWarnings("unused") WHITE_BRIGHT("\033[0;97m"),     // WHITE

    // Bold High Intensity
    @SuppressWarnings("unused") BLACK_BOLD_BRIGHT("\033[1;90m"),    // BLACK
    @SuppressWarnings("unused") RED_BOLD_BRIGHT("\033[1;91m"),      // RED
    @SuppressWarnings("unused") GREEN_BOLD_BRIGHT("\033[1;92m"),    // GREEN
    YELLOW_BOLD_BRIGHT("\033[1;93m"),   // YELLOW
    @SuppressWarnings("unused") BLUE_BOLD_BRIGHT("\033[1;94m"),     // BLUE
    @SuppressWarnings("unused") MAGENTA_BOLD_BRIGHT("\033[1;95m"),  // MAGENTA
    @SuppressWarnings("unused") CYAN_BOLD_BRIGHT("\033[1;96m"),     // CYAN
    @SuppressWarnings("unused") WHITE_BOLD_BRIGHT("\033[1;97m"),    // WHITE

    // High Intensity backgrounds
    @SuppressWarnings("unused") BLACK_BACKGROUND_BRIGHT("\033[0;100m"),     // BLACK
    @SuppressWarnings("unused") RED_BACKGROUND_BRIGHT("\033[0;101m"),       // RED
    @SuppressWarnings("unused") GREEN_BACKGROUND_BRIGHT("\033[0;102m"),     // GREEN
    @SuppressWarnings("unused") YELLOW_BACKGROUND_BRIGHT("\033[0;103m"),    // YELLOW
    @SuppressWarnings("unused") BLUE_BACKGROUND_BRIGHT("\033[0;104m"),      // BLUE
    @SuppressWarnings("unused") MAGENTA_BACKGROUND_BRIGHT("\033[0;105m"),   // MAGENTA
    @SuppressWarnings("unused") CYAN_BACKGROUND_BRIGHT("\033[0;106m"),      // CYAN
    @SuppressWarnings("unused") WHITE_BACKGROUND_BRIGHT("\033[0;107m");     // WHITE

    private final String code;

    Color(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}