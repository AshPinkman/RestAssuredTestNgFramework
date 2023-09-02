package dataprovider;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class MyDataProvider {

        @DataProvider(name = "getUserData")
        public Object[] getLoginData()  {
            return ExcelUtils.getData();
        }

    }
