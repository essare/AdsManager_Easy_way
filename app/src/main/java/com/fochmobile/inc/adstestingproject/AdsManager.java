package com.fochmobile.inc.adstestingproject;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.NativeExpressAdView;

/**
 * ADS MANAGER Class: An open source Java class.
 * @Author ESSARE AYOUB
 * @Created on January 2017
 * @Company FochMobile Inc (c) By ESSARE AYOUB
 * @Copyright (c) 2017 | All RIGHTS RESERVED :v
 * @Url: https://gist.github.com/Ess-Soft/5ded8943dc248111e4fef41460ed931e
 */

public class AdsManager{

    // Your Admob Interstitial ID here !!
    private static final String ADMOB_INTERSTITIAL_ID = "ca-app-pub-xxxxxxxxxxxxxxxx/xxxxxxxxxx";
    private Context mContext;
    private InterstitialAd interstitialAd;

    /**
     * Main Constructor for initializing class
     * It takes only one parameter 'Context'
     * @param context
     * Context is for accessing app resources such
     * as strings.xml etc...
     */
    public AdsManager(Context context){
        mContext = context;
    }

    /**
     * This Method loads ads in AdView
     * The AdView can be passed from any
     * Class or Activity as parameter
     * @param adView
     */
    public void LoadAdsBannerWithInterstitial(final AdView adView){
        if(adView != null) {
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        }
        // AdView will be hidden from the activity until it loads.
        adView.setVisibility(View.INVISIBLE);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Log.d("==> Banner Ad:", " Closed by user!");
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Log.d("==> Banner Ad:", " Failed to load!");
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                Log.d("==> Banner Ad:", " Clicked by user!");
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.d("==> Banner Ad:", " Loaded successfully!");
                adView.setVisibility(View.VISIBLE);
            }

        });
        // Just load INTERSTITIAL Ads
        LoadInterstitial();

    }

    /**
     * This Method loads ads in NativeExpressAdView
     * The NativeExpressAdView can be passed from any
     * Class or Activity as parameter
     * @param nativeExpressAdView
     */
    public void LoadAdsNativeWithInterstitial(final NativeExpressAdView nativeExpressAdView){
        if(nativeExpressAdView != null){
            nativeExpressAdView.loadAd(new AdRequest.Builder().build());
        }
        nativeExpressAdView.setVisibility(View.GONE);
        nativeExpressAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                nativeExpressAdView.setVisibility(View.VISIBLE);
            }
        });

        LoadInterstitial();


    }

    /**
     * This Method loads interstitial ads
     * but keep it on memory until ShowInterstitial()
     * is called then the Interstitial ads will popup in full screen mode
     */
    public void LoadInterstitial(){
        interstitialAd = new InterstitialAd(mContext);
        interstitialAd.setAdUnitId(ADMOB_INTERSTITIAL_ID);
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Log.d("==> Interstitial Ad:", " Closed by user");
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Log.d("==> Interstitial Ad:", " Failed to load");
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                Log.d("==> Interstitial Ad:", " Opened by user");
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.d("==> Interstitial Ad:", " Loaded successfully");
            }
        });
    }

    /**
     * This method shows the interstitial ads on the screen in fullScreen
     * NOTICE: Please call LoadInterstitial() method first or ShowInterstitial()
     * would be null
     */
    public void ShowInterstitial(){
        if(interstitialAd != null && interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        // Reload interstitial after ShowInterstitial is called.
        LoadInterstitial();
    }

}
