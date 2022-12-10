package pages;

public class PageObjectManager {

    private FlightsPage flightsPage = new FlightsPage();
    private AutomationPracticePage automationPracticePage = new AutomationPracticePage();
    private EcommercePage ecommercePage = new EcommercePage();
    private AmazonPage amazonPage = new AmazonPage();
    private LoginPagePracticePage loginPagePracticePage = new LoginPagePracticePage();
    private JqueryPage jqueryPage = new JqueryPage();

    public FlightsPage getFlightsPage() {
        return flightsPage;
    }

    public AutomationPracticePage getAutomationPracticePage() {
        return automationPracticePage;
    }

    public EcommercePage getEcommercePage() {
        return ecommercePage;
    }

    public AmazonPage getAmazonPage() {
        return amazonPage;
    }

    public LoginPagePracticePage getLoginPagePracticePage() {
        return loginPagePracticePage;
    }

    public JqueryPage getJqueryPage() {
        return jqueryPage;
    }
}
