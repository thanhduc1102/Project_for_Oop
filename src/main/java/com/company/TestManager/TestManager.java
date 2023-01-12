package com.company.TestManager;

import com.company.BaseURL;
import com.company.TestManager.TestAPIs._10GetDetailsAuctions.GetDetailsAuctionsTest;
import com.company.TestManager.TestAPIs._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.TestAPIs._12EditAuction.EditAuctionTest;
import com.company.TestManager.TestAPIs._13CreateItem.CreateItemTest;
import com.company.TestManager.TestAPIs._14CreateComment.CreateCommentTest;
import com.company.TestManager.TestAPIs._15GetListComments.GetListCommentsTest;
import com.company.TestManager.TestAPIs._16DeleteComment.DeleteCommentTest;
import com.company.TestManager.TestAPIs._17CreateBid.CreateBidTest;
import com.company.TestManager.TestAPIs._18GetListBids.GetListBidsTest;
import com.company.TestManager.TestAPIs._19GetListCategories.GetListCategoriesTest;
import com.company.TestManager.TestAPIs._1SignUp.SignUpTest;
import com.company.TestManager.TestAPIs._20GetListBrands.GetListBrandsTest;
import com.company.TestManager.TestAPIs._21AcceptMaxBid.AcceptMaxBidTest;
import com.company.TestManager.TestAPIs._22ContactUs.ContactUsTest;
import com.company.TestManager.TestAPIs._23LikeAuction.LikeAuctionTest;
import com.company.TestManager.TestAPIs._24GetListLikes.GetListLikesTest;
import com.company.TestManager.TestAPIs._25TotalLikesOfAuction.TotalLikesOfAuctionTest;
import com.company.TestManager.TestAPIs._26GetNews.GetNewsTest;
import com.company.TestManager.TestAPIs._27ReadNews.ReadNewsTest;
import com.company.TestManager.TestAPIs._28GetNotifications.GetNotificationsTest;
import com.company.TestManager.TestAPIs._29ReadNotifications.ReadNotificationsTest;
import com.company.TestManager.TestAPIs._2Login.LoginTest;
import com.company.TestManager.TestAPIs._30GetSlider.GetSliderTest;
import com.company.TestManager.TestAPIs._3Logout.LogoutTest;
import com.company.TestManager.TestAPIs._4EditAccount.EditAccountTest;
import com.company.TestManager.TestAPIs._5Search.SearchTest;
import com.company.TestManager.TestAPIs._6GetListAuctions.GetListAuctionsTest;
import com.company.TestManager.TestAPIs._7GetListAuctionsByStatus.GetListAuctionsByStatusTest;
import com.company.TestManager.TestAPIs._8GetListAuctionsByUser.GetListAuctionsByUserTest;
import com.company.TestManager.TestAPIs._9GetListAuctionsByType.GetListAuctionsByTypeTest;
import com.company.constants.EndpointConstants;

// quản lí các test và chạy test được chọn khi có yêu cầu
public class TestManager {

    public void startTest(int apiId, BaseURL baseUrlObject) {
        Test test = switch (apiId) {
            case 1 -> new SignUpTest(baseUrlObject, EndpointConstants.SIGN_UP);
            case 2 -> new LoginTest(baseUrlObject, EndpointConstants.LOG_IN);
            case 3 -> new LogoutTest(baseUrlObject, EndpointConstants.LOG_OUT);
            case 4 -> new EditAccountTest(baseUrlObject, EndpointConstants.EDIT_ACCOUNT);
            case 5 -> new SearchTest(baseUrlObject, EndpointConstants.SEARCH);
            case 6 -> new GetListAuctionsTest(baseUrlObject, EndpointConstants.GET_LIST_AUCTIONS);
            case 7 -> new GetListAuctionsByStatusTest(baseUrlObject, EndpointConstants.GET_LIST_AUCTIONS_BY_STATUS);
            case 8 -> new GetListAuctionsByUserTest(baseUrlObject, EndpointConstants.GET_LIST_AUCTIONS_BY_USER);
            case 9 -> new GetListAuctionsByTypeTest(baseUrlObject, EndpointConstants.GET_LIST_AUCTIONS_BY_TYPE);
            case 10 -> new GetDetailsAuctionsTest(baseUrlObject, EndpointConstants.GET_DETAILS_AUCTIONS);
            case 11 -> new CreateAuctionTest(baseUrlObject, EndpointConstants.CREATE_AUCTION);
            case 12 -> new EditAuctionTest(baseUrlObject, EndpointConstants.EDIT_AUCTION);
            case 13 -> new CreateItemTest(baseUrlObject, EndpointConstants.CREATE_ITEM);
            case 14 -> new CreateCommentTest(baseUrlObject, EndpointConstants.CREATE_COMMENT);
            case 15 -> new GetListCommentsTest(baseUrlObject, EndpointConstants.GET_LIST_COMMENTS);
            case 16 -> new DeleteCommentTest(baseUrlObject, EndpointConstants.DELETE_COMMENT);
            case 17 -> new CreateBidTest(baseUrlObject, EndpointConstants.CREATE_BID);
            case 18 -> new GetListBidsTest(baseUrlObject, EndpointConstants.GET_LIST_BIDS);
            case 19 -> new GetListCategoriesTest(baseUrlObject, EndpointConstants.GET_LIST_CATEGORIES);
            case 20 -> new GetListBrandsTest(baseUrlObject, EndpointConstants.GET_LIST_BRANDS);
            case 21 -> new AcceptMaxBidTest(baseUrlObject, EndpointConstants.ACCEPT_MAX_BID);
            case 22 -> new ContactUsTest(baseUrlObject, EndpointConstants.CONTACT_US);
            case 23 -> new LikeAuctionTest(baseUrlObject, EndpointConstants.LIKE_AUCTION);
            case 24 -> new GetListLikesTest(baseUrlObject, EndpointConstants.GET_LIST_LIKES);
            case 25 -> new TotalLikesOfAuctionTest(baseUrlObject, EndpointConstants.TOTAL_LIKES_OF_AUCTION);
            case 26 -> new GetNewsTest(baseUrlObject, EndpointConstants.GET_NEWS);
            case 27 -> new ReadNewsTest(baseUrlObject, EndpointConstants.READ_NEWS);
            case 28 -> new GetNotificationsTest(baseUrlObject, EndpointConstants.GET_NOTIFICATIONS);
            case 29 -> new ReadNotificationsTest(baseUrlObject, EndpointConstants.READ_NOTIFICATIONS);
            case 30 -> new GetSliderTest(baseUrlObject, EndpointConstants.GET_SLIDER);
            default -> null;
        };
        if (test == null) return;
        test.startTest();
    }
}
