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

    LEAD_BY_SALES_REP("report lead by salesrep"),
    OPPORTUNITY_BY_SALES_REP("report opportunity by salesrep"),
    CLOSED_WON_BY_SALES_REP("report closed-won by salesrep"),
    CLOSED_LOST_BY_SALES_REP("report closed-lost by salesrep"),
    OPEN_BY_SALES_REP("report open by salesrep"),

    OPPORTUNITY_BY_PRODUCT("report opportunity by product"),
    CLOSED_WON_OPPORTUNITIES_BY_PRODUCT("report closed-won by product"),
    CLOSED_LOST_OPPORTUNITIES_BY_PRODUCT("report closed-lost by product"),
    OPEN_OPPORTUNITIES_BY_PRODUCT("report open by product"),

    OPPORTUNITY_BY_COUNTRY("report opportunity by country"),
    CLOSED_WON_OPPORTUNITIES_BY_COUNTRY("report closed-won by country"),
    CLOSED_LOST_OPPORTUNITIES_BY_COUNTRY("report closed-lost by country"),
    OPEN_OPPORTUNITIES_BY_COUNTRY("report open by country"),

    OPPORTUNITY_BY_CITY("report opportunity by city"),
    CLOSED_WON_OPPORTUNITIES_BY_CITY("report closed-won by city"),
    CLOSED_LOST_OPPORTUNITIES_BY_CITY("report closed-lost by city"),
    OPEN_OPPORTUNITIES_BY_CITY("report open by city"),

    OPPORTUNITY_BY_INDUSTRY("report opportunity by industry"),
    CLOSED_WON_OPPORTUNITIES_BY_INDUSTRY("report closed-won by industry"),
    CLOSED_LOST_OPPORTUNITIES_BY_INDUSTRY("report closed-lost by industry"),
    OPEN_OPPORTUNITIES_BY_INDUSTRY("report open by industry"),

    MEAN_OPPORTUNITIES_PER_ACCOUNT("mean opps per account"),
    MEDIAN_OPPORTUNITIES_PER_ACCOUNT("median opps per account"),
    MAXIMUM_OPPORTUNITIES_PER_ACCOUNT("max opps per account"),
    MINIMUM_OPPORTUNITIES_PER_ACCOUNT("min opps per account"),

    MEAN_QUANTITY_PER_PRODUCT("mean quantity per account"),
    MEDIAN_QUANTITY_PER_PRODUCT("median quantity per account"),
    MAX_QUANTITY_PER_PRODUCT("max quantity per account"),
    MIN_QUANTITY_PER_PRODUCT("min quantity per account"),

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


