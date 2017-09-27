package common;

import android.util.Pair;

import java.io.IOException;

import app.CityGuideApplication;


public class ApiTokenManager {

    private static String AVOS_CLOUD_LIVE_APP_ID = "egDFgpKJaazFLvnpspcyqR3I-gzGzoHsz";
    private static String AVOS_CLOUD_LIVE_APP_KEY = "pBfmmEgfW6xEyDmW91Weurvp";
    private static String AVOS_CLOUD_TEST_APP_ID = "zwyFFMurfKTXti21yknLeiQE-gzGzoHsz";
    private static String AVOS_CLOUD_TEST_APP_KEY = "hvCgYM4O7tTsa38BvIawdy1Q";

    private static ApiTokenManager INSTANCE;


    // A singleton instance
    private ApiTokenManager() {}


    // This should be called at application onCreate(), which is the very first action after
    // app load
    public static ApiTokenManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApiTokenManager();
        }
        return INSTANCE;
    }

    public void initialize(CityGuideApplication application) throws IOException {
//        properties = new Properties();
//        AssetManager assetManager = application.getResources().getAssets();
//        properties.load(assetManager.open("api_token.properties"));
    }

    /**
     * 线上环境
     * @return
     */
    public Pair<String, String> getAvoCloudReleaseApiToken() {
        return new Pair(AVOS_CLOUD_LIVE_APP_ID,
                        AVOS_CLOUD_LIVE_APP_KEY);
    }

    /**
     * 测试环境
     * @return
     */
    public Pair<String, String> getAvoCloudDebugApiToken() {
        return new Pair(AVOS_CLOUD_TEST_APP_ID,
                AVOS_CLOUD_TEST_APP_KEY);
    }

}
