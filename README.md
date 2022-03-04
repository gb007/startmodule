# StartModule模块使用

## 1.在工程的根目录build.gradle中添加kotlin，butterknife插件依赖

````
    dependencies {
        classpath "com.android.tools.build:gradle:7.0.3"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20"
        classpath 'com.jakewharton:butterknife-gradle-plugin:10.2.1'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }

````

## 2.在需要引用此类库模块的build.gradle中引入依赖

 ````
dependencies {
	implementation 'com.github.gb007:startmodule:Tag'
	}

````

## 3.初始化配置信息

### 3.1 Manifest中添加启动页面Activity, 并配置为程序启口，theme根据需求自己配置

````
        <activity android:name="com.hollysmart.startmodule.SplashActivity"
            android:exported="true"
            android:screenOrientation="portrait"
            android:theme="@style/LunchTheme">

            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>

        </activity>

````

### 3.2 Application中初始化StartModule配置

````
    private fun initStartModule(){
        //启动页加载展示时长
        StartModuleConfig.SPLASH_LOAD_DURATION = 3000L
        //启动页背景图片资源ID
        StartModuleConfig.SPLASH_LOAD_BG_RESOURCE_ID = getResources().getIdentifier("bg_splash", "drawable", getPackageName());
        //是否有引导页(默认为false)
        StartModuleConfig.HAS_GUIDE = true

        val guide_1 = getResources().getIdentifier("icon_guide", "mipmap", getPackageName())
        val guide_2 = getResources().getIdentifier("icon_guide_2", "mipmap", getPackageName())
        val guide_3 = getResources().getIdentifier("icon_guide", "mipmap", getPackageName())
        val guide_4 = getResources().getIdentifier("icon_guide_2", "mipmap", getPackageName())

        //引导页背景图片资源ID（List<Int>）
        StartModuleConfig.GUIDE_RESOURCEID = listOf(guide_1,guide_2,guide_3,guide_4)
        //启动模块结束后，跳转的Activity页面
        StartModuleConfig.STARTPAGE = LoginActivity::class.java

    }

````
