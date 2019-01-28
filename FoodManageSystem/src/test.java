import java.util.regex.Pattern;

import com.Dao.MacMenuDao;
import com.Dao.MrPizzaMenuDao;
import com.Service.MacMenuService;
import com.bean.MacMenu;
import com.bean.MrPizzaMenu;

public class test {

	public static void main(String[] args) throws Exception {
		MacMenu mm = new MacMenu();
		mm.setMac_id(2);
		mm.setMac_rep(0);
		mm.setMac_name("가나다");
		mm.setMac_seq(2);;
		mm.setMac_price(30000);
		
		MacMenuService mmd = MacMenuService.getInstance();
		mmd.macSeqExamine(0);
		//mmd.macNameExamine("가나다");
		//mmd.macMenuDelete(1);
		//mmd.macMenuUpdate(mm);
		//System.out.println(mmd);
		//-----------------------------------------------//
		String ab = "1214301";
		boolean a = Pattern.matches("^[0-9]{1,7}+$", ab);
				
				
		System.out.println(a);
		
	}

}
