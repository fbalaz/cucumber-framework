package utilities;

import pages.PageObjectManager;

import java.io.IOException;
import java.util.ArrayList;

public class TestContextSetup {

    public GenericUtils genericUtils;
    public PageObjectManager pageObjectManager;
    public String extractedContactEmail;
    public ArrayList<String> tabTitles = new ArrayList<>();

    public TestContextSetup() throws IOException {
        this.genericUtils = new GenericUtils();
        this.pageObjectManager = new PageObjectManager();
    }
}
