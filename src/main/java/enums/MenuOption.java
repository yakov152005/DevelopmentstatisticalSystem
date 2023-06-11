package enums;

public enum MenuOption {
    ADD_COUNTRY("A"),
    FIND_COUNTRY("F"),
    LIST_COUNTRIES("L"),
    SORT_COUNTRIES("S"),
    CONTINENT_FILTER("C"),
    QUIT("Q");

    private final String code;

    MenuOption(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static MenuOption fromCode(String code) {
        for (MenuOption option : values()) {
            if (option.code.equalsIgnoreCase(code)) {
                return option;
            }
        }
        return null;
    }
}