package com.fochmobile.inc.adstestingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.NativeExpressAdView;

public class MainActivity extends AppCompatActivity {

    public AdView adView;
    public AdsManager adsManager;
    public NativeExpressAdView nativeExpressAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Banner
        adsManager = new AdsManager(this);

        adView = (AdView)findViewById(R.id.myBanner);
        adsManager.LoadAdsBannerWithInterstitial(adView);



        // Native
        nativeExpressAdView = (NativeExpressAdView)findViewById(R.id.myNative);
        adsManager.LoadAdsNativeWithInterstitial(nativeExpressAdView);


        Button btn = (Button)findViewById(R.id.myButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // your code here...
                adsManager.ShowInterstitial();
            }
        });
    }
}
