package com.example.crmmysqlproject.crm.domain.Crm;

public enum Command {
    CREATE_LEAD("new lead"),
    SHOW_LEADS("show leads"),
    CONVERT("convert"),
    OPPORTUNITY_LOOKUP("lookup opportunity"),
    CLOSE_LOST("close-lost"),
    CLOSE_WON("close-won"),
    NEW_SALES_REP("new salesrep"),
    SHOW_SALES_REP("show salesrep"),
    HELP("--help"),
    EXIT("exit"),
    INVALID("invalid"),
    ;

    private final String command;

    public String getCommand() {
        return this.command;
    }

    private Command(String command) {
        this.command = command;
    }

    public static Command fromString(String text) {
        for (Command b : Command.values()) {
            if (b.command.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return Command.INVALID;
    }

}


