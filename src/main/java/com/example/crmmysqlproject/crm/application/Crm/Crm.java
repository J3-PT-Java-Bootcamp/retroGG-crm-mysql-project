package com.example.crmmysqlproject.crm.application.Crm;

import com.example.crmmysqlproject.crm.application.Leads.ConvertLeadToOpportunity.ConvertLeadToOpportunityRequest;
import com.example.crmmysqlproject.crm.application.Leads.ConvertLeadToOpportunity.ConvertLeadToOpportunityUseCase;
import com.example.crmmysqlproject.crm.application.Leads.CreateLead.CreateLeadRequest;
import com.example.crmmysqlproject.crm.application.Leads.CreateLead.CreateLeadUseCase;
import com.example.crmmysqlproject.crm.application.Leads.FindAll.FindAllLeads;
import com.example.crmmysqlproject.crm.application.Opportunity.CloseLostOpportunity.CloseLostOpportunity;
import com.example.crmmysqlproject.crm.application.Opportunity.CloseWonOpportunity.CloseWonOpportunity;
import com.example.crmmysqlproject.crm.application.Opportunity.FindOpportunity.FindOpportunity;
import com.example.crmmysqlproject.crm.application.SalesRep.Create.CreateSalesRep;
import com.example.crmmysqlproject.crm.application.SalesRep.Create.CreateSalesRepRequest;
import com.example.crmmysqlproject.crm.application.SalesRep.FindAll.FindAllSalesRep;
import com.example.crmmysqlproject.crm.application.SalesRep.reporting.ReportService;
import com.example.crmmysqlproject.crm.application.SalesRep.reporting.reports.LeadsBySalesRep;
import com.example.crmmysqlproject.crm.application.Shared.UUIDRequest;
import com.example.crmmysqlproject.crm.domain.Account.Industry;
import com.example.crmmysqlproject.crm.domain.Account.IndustryNotFoundException;
import com.example.crmmysqlproject.crm.domain.Crm.Command;
import com.example.crmmysqlproject.crm.domain.Lead.LeadNotFoundException;
import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityNotFoundException;
import com.example.crmmysqlproject.crm.domain.Opportunity.ProductType;
import com.example.crmmysqlproject.crm.domain.Opportunity.ProductTypeNotFoundException;
import com.example.crmmysqlproject.crm.domain.Sales.SalesRepNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
public final class Crm {

    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    private CreateLeadUseCase createLeadUseCase;
    @Autowired
    private ConvertLeadToOpportunityUseCase convertLeadToOpportunityUseCase;
    @Autowired
    private FindAllLeads findAllLeads;

    @Autowired
    private FindOpportunity findOpportunity;

    @Autowired
    private CloseLostOpportunity closeLostOpportunity;

    @Autowired
    private CloseWonOpportunity closeWonOpportunity;

    @Autowired
    private CreateSalesRep createSalesRep;

    @Autowired
    private FindAllSalesRep findAllSalesRep;

    @Autowired
    private ReportService reportService;

    public void start() {
        this.printWelcome();
        String inputCommand;
        boolean exit = false;
        do {
            this.printCommandRequest();
            inputCommand = scanner.nextLine().toLowerCase();
            Command command = Command.fromString(inputCommand);
            switch (command) {
                case CREATE_LEAD -> this.createLead();
                case SHOW_LEADS -> this.showLeads();
                case CONVERT -> this.convertLeadToOpportunity();
                case OPPORTUNITY_LOOKUP -> this.showOpportunity();
                case CLOSE_LOST -> this.closeLostOpportunity();
                case CLOSE_WON -> this.closeWonOpportunity();
                case NEW_SALES_REP -> this.createSalesRep();
                case SHOW_SALES_REP -> this.showSalesReps();
                case LEAD_BY_SALES_REP -> this.leadBySalesRep();
                case OPPORTUNITY_BY_SALES_REP -> this.opportunityBySalesRep();
                case CLOSED_WON_BY_SALES_REP -> this.closedWonBySalesRep();
                case CLOSED_LOST_BY_SALES_REP -> this.closedLostBySalesRep();
                case OPEN_BY_SALES_REP -> this.openBySalesRep();
                case HELP -> this.printHelp();
                case EXIT -> exit = true;
                default -> System.out.println("Unavailable command.");
            }
        } while (!exit);
        this.printQuit();
    }

    private void openBySalesRep() {
        printBySalesRep(this.reportService.openOpportunitiesBySalesRep());
    }

    private void closedLostBySalesRep() {
        printBySalesRep(this.reportService.closedLostOpportunitiesBySalesRep());
    }

    private void closedWonBySalesRep() {
        printBySalesRep(this.reportService.closedWonOpportunitiesBySalesRep());
    }

    private void opportunityBySalesRep() {
        printBySalesRep(this.reportService.opportunitiesBySalesRep());
    }

    private void printBySalesRep(List<Object[]> objects) {
        for (var object: objects) {
            System.out.printf("%s - %d %n", object[0], object[1]);
        }
    }
    private void leadBySalesRep() {
        var leadsBySales = this.reportService.listLeadsBySalesRep();
        for (var lead: leadsBySales) {
            System.out.printf("%s - %d %n", lead[0], lead[1]);
        }
    }

    private void showSalesReps() {
        var salesRep = this.findAllSalesRep.run();
        System.out.println("""
                Listing sales reps
                """);
        System.out.println(salesRep);
    }

    private void createSalesRep() {
        System.out.println("SalesRep creation wizard");
        System.out.println("========================");

        System.out.println("Name: ");
        String name = scanner.nextLine();

        var request = new CreateSalesRepRequest(name);
        this.createSalesRep.run(request);
        System.out.println("SalesRep created successfully!");
    }

    private void printCommandRequest() {
        System.out.println("Type " + Command.HELP.getCommand() + " to show the available commands.");
        System.out.print("Command: ");
    }

    private void printWelcome() {
        System.out.println("Welcome to the CRM. You can start managing your customers.");
    }

    private void printQuit() {
        System.out.println("Saving all changes...");
        System.out.println("CRM has been shut down");
    }

    private void printHelp() {
        System.out.println("""
                Commands list
                ================================
                \tnew lead \t-\tStarts a create lead wizard.
                \tshow leads \t-\tShow all leads.
                \tconvert \t-\tIf lead with id is found, convert lead to opportunity.
                \tlookup opportunity \t-\tShow opportunity if found.
                \tclose-lost \t-\tClose lost opportunity.
                \tclose-won \t-\tClose won opportunity.
                \tnew salesrep\t-\tCreate new sales rep.
                \tshow salesrep\t-\tShow sales rep.
                                
                \tReports by SalesRep.
                \t\tA count of Leads by SalesRep can be displayed by typing “Report Lead by SalesRep”
                \t\tA count of all Opportunities by SalesRep can be displayed by typing “Report Opportunity by SalesRep”
                \t\tA count of all CLOSED_WON Opportunities by SalesRep can be displayed by typing “Report CLOSED-WON by SalesRep”
                \t\tA count of all CLOSED_LOST Opportunities by SalesRep can be displayed by typing “Report CLOSED-LOST by SalesRep”
                \t\tA count of all OPEN Opportunities by SalesRep can be displayed by typing “Report OPEN by SalesRep”

                \tReports by Opportunity Product.
                \t\tA count of all Opportunities by the product can be displayed by typing “Report Opportunity by product”
                \t\tA count of all CLOSED_WON Opportunities by the product can be displayed by typing “Report CLOSED-WON by product”
                \t\tA count of all CLOSED_LOST Opportunities by the product can be displayed by typing “Report CLOSED-LOST by product”
                \t\tA count of all OPEN Opportunities by the product can be displayed by typing “Report OPEN by product”
                                
                \tReports by Opportunity Country.
                \t\tA count of all Opportunities by country can be displayed by typing “Report Opportunity by Country”
                \t\tA count of all CLOSED_WON Opportunities by country can be displayed by typing “Report CLOSED-WON by Country”
                \t\tA count of all CLOSED_LOST Opportunities by country can be displayed by typing “Report CLOSED-LOST by Country”
                \t\tA count of all OPEN Opportunities by country can be displayed by typing “Report OPEN by Country”
                                
                \tReports by Opportunity City.
                \t\tA count of all Opportunities by the city can be displayed by typing “Report Opportunity by City”
                \t\tA count of all CLOSED_WON Opportunities by the city can be displayed by typing “Report CLOSED-WON by City”
                \t\tA count of all CLOSED_LOST Opportunities by the city can be displayed by typing “Report CLOSED-LOST by City”
                \t\tA count of all OPEN Opportunities by the city can be displayed by typing “Report OPEN by City”
                                
                \tReports by Opportunity Industry.
                \t\tA count of all Opportunities by industry can be displayed by typing “Report Opportunity by Industry”
                \t\tA count of all CLOSED_WON Opportunities by industry can be displayed by typing “Report CLOSED-WON by Industry”
                \t\tA count of all CLOSED_LOST Opportunities by industry can be displayed by typing “Report CLOSED-LOST by Industry”
                \t\tA count of all OPEN Opportunities by industry can be displayed by typing “Report OPEN by Industry”
                                
                \tReports by Opportunity States.
                \t\tThe mean number of Opportunities associated with an Account can be displayed by typing “Mean Opps per Account”
                \t\tThe median number of Opportunities associated with an Account can be displayed by typing “Median Opps per Account”
                \t\tThe maximum number of Opportunities associated with an Account can be displayed by typing “Max Opps per Account”
                \t\tThe minimum number of Opportunities associated with an Account can be displayed by typing “Min Opps per Account”
                
                \tReports by Product Quantity.
                \t\tThe mean quantity of products order can be displayed by typing “Mean Quantity”
                \t\tThe median quantity of products order can be displayed by typing “Median Quantity”
                \t\tThe maximum quantity of products order can be displayed by typing “Max Quantity”
                \t\tThe minimum quantity of products order can be displayed by typing “Min Quantity”

                """);
    }

    public void createLead() {
        System.out.println("Lead creation wizard");
        System.out.println("========================");

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Phone: ");
        String phone = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        System.out.println("Company: ");
        String company = scanner.nextLine();

        System.out.println("SalesRep ID: ");
        Integer salesRepId = scanner.nextInt();
        var request = new CreateLeadRequest(name, phone, email, company, salesRepId);
        try {
            this.createLeadUseCase.run(request);
            System.out.println("Lead created successfully!");
        } catch (SalesRepNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void convertLeadToOpportunity() {
        System.out.println("Which lead do you want to convert?");
        System.out.print("ID: ");
        int leadId = Integer.parseInt(scanner.nextLine());
        ProductType productType = null;

        while (productType == null) {
            try {
                System.out.println("Product interest?");
                for (ProductType type : ProductType.values()) {
                    System.out.printf("\t%s%n", type);
                }
                String productTypeInput = scanner.nextLine();
                productType = ProductType.fromString(productTypeInput);
            } catch (ProductTypeNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Which quantity?");
        int quantity = Integer.parseInt(scanner.nextLine());

        Industry industry = null;
        do {
            try {
                System.out.println("Industry?");
                for (Industry type : Industry.values()) {
                    System.out.printf("\t%s%n", type);
                }
                String industryInput = scanner.nextLine();
                industry = Industry.fromString(industryInput);
            } catch (IndustryNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (industry == null);

        System.out.println("Number of employees?");
        int numberOfEmployees = Integer.parseInt(scanner.nextLine());

        System.out.println("City?");
        String city = scanner.nextLine();
        System.out.println("Country?");
        String country = scanner.nextLine();

        var request = new ConvertLeadToOpportunityRequest(leadId, productType, quantity, industry, numberOfEmployees, city, country);
        try {
            this.convertLeadToOpportunityUseCase.run(request);
            System.out.println("Lead converted successfully.");
        } catch (LeadNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showLeads() {
        var leads = this.findAllLeads.run();
        System.out.println("""
                ID - Name
                """);
        System.out.println(leads);
    }

    private void showOpportunity() {
        System.out.print("ID: ");
        String idInput = scanner.nextLine();
        UUID id = UUID.fromString(idInput);
        try {
            var opportunity = this.findOpportunity.run(id);
            System.out.println(opportunity);
        } catch (OpportunityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void closeLostOpportunity() {
        System.out.print("ID: ");
        String idInput = scanner.nextLine();
        UUID id = UUID.fromString(idInput);
        try {
            this.closeLostOpportunity.run(new UUIDRequest(id));
            System.out.printf("Opportunity with id: %s closed lost successfully.%n", id);
        } catch (OpportunityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void closeWonOpportunity() {
        System.out.print("ID: ");
        String idInput = scanner.nextLine();
        UUID id = UUID.fromString(idInput);
        try {
            this.closeWonOpportunity.run(new UUIDRequest(id));
            System.out.printf("Opportunity with id: %s closed won successfully.%n", id);
        } catch (OpportunityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
