package ub.wallethub.tests;

import org.testng.annotations.Test;
import ub.wallethub.pages.InsuranceCompanyPage;
import ub.wallethub.pages.LoginPage;
import ub.wallethub.pages.WalletHubHomePage;
import ub.wallethub.pages.WriteReview;

public class WalletHubTest extends AbstractTest {
	LoginPage Pages_Login;
	WalletHubHomePage Pages_Home;
	InsuranceCompanyPage Pages_Insurance;
	WriteReview Pages_Review;
	
	private String policy = "Health";
	private String confirm_company_review_msg ="Your Test Insurance Company review has been posted.";

	@Test
	public void verifyWalletHub() {
		Pages_Home = new WalletHubHomePage(driver);		
		Pages_Home.goToLoginPage();

		Pages_Login = new LoginPage(driver);		
		Pages_Login.loginToWalletHub();		
		Pages_Login.goToInsuranceCompanyPage();
	
		Pages_Insurance = new InsuranceCompanyPage(driver);		
		Pages_Insurance.selectFiveStars();
		
		Pages_Review = new WriteReview(driver);		
		Pages_Review.selectYourPolicy(policy);
		Pages_Review.selectYourRating();
		Pages_Review.writeYourReview(review);
		Pages_Review.confirmYourReview(confirm_company_review_msg);
		Pages_Review.goToYourProfile();
		Pages_Review.goToReviewTab();
		Pages_Review.displayReviewFeedWithYourText(review);
		
		
		

	}
}
