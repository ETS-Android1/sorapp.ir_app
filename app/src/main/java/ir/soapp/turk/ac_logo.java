package ir.soapp.turk;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

public class ac_logo extends AppCompatActivity
{

/*-------------------------------------------------------------------------------------*/
    boolean Changed_Ac = false,Log_Condition=false,CONDITION=true;
    boolean Internet;
    CountDownTimer Timier2;
    CountDownTimer timer;
    int RETERY_GET_DATA=1;
/*-------------------------------------------------------------------------------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_logo);

//        try
//        {
//            Cls_Main.GET_JSON_ALL_POSTS("[{\"Id\":\"545\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/Galaxy-s9-software-update.jpg\",\"Title\":\"بروزرسانی رابط کاربری One UI 2.1 در هفته جاری برای گوشی\u200Cهای گلکسی S9 و S9+ عرضه می\u200Cشود\"},{\"Id\":\"542\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/5d8a403b2e22af05a65012b8.jpg\",\"Title\":\"شیائومی به دنبال عرضه گوشی هوشمند با حافظه رم 16 گیگابایتی است\"},{\"Id\":\"539\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/original-battlefield-5.jpg\",\"Title\":\"آپدیت جدید بازی Battlefield 5 منتشر شد\"},{\"Id\":\"536\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/Chrome-vs-Edge-85d127b1b91045df9dafb1e9b8d0c9f0.jpg\",\"Title\":\"و اینک جنگ مدرن مرورگرها؛ پیشنهاد گوگل کروم به جای استفاده از مرورگر Edge\"},{\"Id\":\"534\",\"Image\":\"\",\"Title\":\"چطور با گوشی در عکاسی از مناظر بهترین باشیم؟\"},{\"Id\":\"530\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/Takminer-Cover.jpg\",\"Title\":\"انواع دستگاه ماینر\"},{\"Id\":\"527\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/is-5g-harmful.jpg\",\"Title\":\"آیا فناوری 5G باعث ایجاد بیماری می\u200Cشود؟\"},{\"Id\":\"523\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/m01.jpg\",\"Title\":\"نگاهی بر گوشی جدید Galaxy M01 سامسونگ و مقایسه آن با Galaxy A01\"},{\"Id\":\"520\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/ios-14.jpg\",\"Title\":\"آپدیت iOS 14 برای کدام گوشی\u200Cها ارائه می\u200Cشود؟\"},{\"Id\":\"517\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/bourse.jpg\",\"Title\":\"سودای ایرانسل برای پیوستن به بورس\"},{\"Id\":\"513\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/mi-mix-alpha-2.jpg\",\"Title\":\"اجزای داخلی گوشی مرموز Mi Mix Alpha شیائومی به نمایش گذاشته شد\"},{\"Id\":\"510\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/scorn.jpg\",\"Title\":\"تریلر تماشایی کنسول بازی Xbox Series X که شاهکار PC است!\"},{\"Id\":\"507\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/960x0.jpg\",\"Title\":\"اپل سارقان آیفون در اعتراضات آمریکا را ردیابی می\u200Cکند\"},{\"Id\":\"504\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/smartphones-look-1.jpg\",\"Title\":\"چرا گوشی\u200Cهای هوشمند شکل و شمایل مشابهی دارند؟\"},{\"Id\":\"501\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/PlayStation-5.jpg\",\"Title\":\"از خداحافظی اجباری با PS4 تا قدرت نمایی PS5 در بازی\u200Cها\"},{\"Id\":\"498\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/hack.jpg\",\"Title\":\"یکی از عواقب عجیب قرنطینه خانگی؛ افزایش 630 درصدی حملات هکری\"},{\"Id\":\"495\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/XT-SERIES-2.jpg\",\"Title\":\"قیمت CPUهای گیمینگ AMD Ryzen 3000XT مشخص شد\"},{\"Id\":\"492\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/Honor-Play4-render-black-800x372-1.jpg\",\"Title\":\"رندر رسمی گوشی Honor Play 4 5G پیش از معرفی رسمی منتشر شد\"},{\"Id\":\"489\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/SAM-MO-3.jpg\",\"Title\":\"حرفه\u200Cای تر از حرفه\u200Cای: سامسونگ مانیتورهای گیمینگ Odyssey G7 را روانه بازار کرد\"},{\"Id\":\"487\",\"Image\":\"\",\"Title\":\"دور زدن تحریم\u200Cها به سبک چینی\"},{\"Id\":\"484\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/06\\/AI.jpg\",\"Title\":\"اخراج برخی از کارمندان بخش خبری مایکروسافت و جایگزین کردن آنها با ربات\u200Cهای هوش مصنوعی\"},{\"Id\":\"481\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/google-stay-home.jpg\",\"Title\":\"کمک مالی گوگل به کارکنان خود برای ایجاد دفاتر کار خانگی\"},{\"Id\":\"478\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Android-11-1.jpg\",\"Title\":\"گوگل رویداد معرفی اندروید ۱۱ را به تعویق انداخت\"},{\"Id\":\"475\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/microsoft_windows_10-2004.jpg\",\"Title\":\"کدام قابلیت\u200Cهای ویندوز 10 در نسخه جدید 2004 حذف شد؟\"},{\"Id\":\"472\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/uv-light-against-coronavirus-uv-c.jpg\",\"Title\":\"آیا اشعه فرابنفش می\u200Cتواند ویروس کرونا را از بین ببرد؟\"},{\"Id\":\"469\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/p40pro-a.jpg\",\"Title\":\"آیا پرچمداران هواوی در سال 2021 به تراشه\u200Cهای اسنپ دراگون مجهز می\u200Cشوند؟\"},{\"Id\":\"466\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Yoga-Duet-7i-IdeaPad-Duet3i.jpg\",\"Title\":\"با دو تبلت جدید لنوو آشنا شوید؛ مجهز به کیبورد جداشونده برای رقابت با سرفیس\"},{\"Id\":\"464\",\"Image\":\"\",\"Title\":\"دلیل دشمنی آمریکا با هوآوی چیست؟\"},{\"Id\":\"460\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/photo_2020-02-16_10-29-59-1140x570-1.jpg\",\"Title\":\"گوشی گلکسی نوت 20 سامسونگ\"},{\"Id\":\"458\",\"Image\":\"\",\"Title\":\"نسخه جدید ویندوز 10 نیامده دردسر ساز شد؛ فعلاً سیستم عامل خود را آپدیت نکنید\"},{\"Id\":\"455\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/6217055_052820-cc-ap-trump-img.jpg\",\"Title\":\"فرمان اجرایی ترامپ فعالیت شبکه\u200Cهای اجتماعی را محدود می\u200Cکند\"},{\"Id\":\"451\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/apple-id.jpg\",\"Title\":\"«ساخت اپل آی دی» برای ایرانی\u200Cها ممنوع شد\"},{\"Id\":\"448\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/how-to-take-a-screenshot-on-iphone-8.jpg\",\"Title\":\"آیا اسکرین\u200Cشات گرفتن هم جرم محسوب می\u200Cشود؟\"},{\"Id\":\"446\",\"Image\":\"\",\"Title\":\"کسب درآمد از طریق تولید ویدیو و محتوا برای کاربران پرطرفدار اینستاگرام ممکن شد\"},{\"Id\":\"443\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/HMS-Header-800x450-1.jpg\",\"Title\":\"هرآنچه باید درباره سرویس\u200Cهای موبایل هواوی (HMS) بدانیم\"},{\"Id\":\"440\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/02AbmH2zwX6C6bBJvgbhmMI-2.fit_lim.v_1590609312-800x450-1.jpg\",\"Title\":\"آپدیت جدید ویندوز 10 همراه با هسته داخلی لینوکس و تغییراتی در کورتانا منتشر شد\"},{\"Id\":\"437\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Android-app-permissions-1.jpg\",\"Title\":\"هر آنچه درباره\u200Cی دسترسی\u200Cهای اپلیکیشن در اندروید باید بدانید\"},{\"Id\":\"434\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Untitled-1-57.jpg\",\"Title\":\"به زودی امکان نمایش گیم\u200Cپلی بازی\u200Cها در پلی استور گوگل فراهم می\u200Cشود\"},{\"Id\":\"431\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/dims-1_InPixio.jpg\",\"Title\":\"نگاهی به مشخصات خودرو برقی دایسون؛ مرگ زودرس جدی ترین رقیب تسلا\"},{\"Id\":\"425\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/hp-1.jpg\",\"Title\":\"سری جدید لپ تاپ های HP EliteBook\"},{\"Id\":\"422\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/iphone-12-pro-concept.jpg\",\"Title\":\"OLED های آیفون\"},{\"Id\":\"419\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/phantom_canyon-4.jpg\",\"Title\":\"مینی کامپیوتر گیمینگ Phantom\"},{\"Id\":\"414\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Samsung-Galaxy-Note-20-Renders-2-1200x675-1.jpg\",\"Title\":\"اولین رندر گوشی گلکسی نوت 20 پلاس منتشر شد\"},{\"Id\":\"411\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/apple-repair.jpg\",\"Title\":\"کمک مالی اپل به تعمیرگاه\u200Cهای مجاز در دوران سخت کرونا\"},{\"Id\":\"408\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/sony-xperia-1-ii-black-back-front-920x470-1.jpg\",\"Title\":\"سونی گوشی Xperia 1 II را با قیمت سرسام آور 1200 دلار عرضه می\u200Cکند\"},{\"Id\":\"406\",\"Image\":\"\",\"Title\":\"«شیائومی» با لپ تاپ\u200Cهای جدید RedmiBook 16 به جنگ بزرگان بازار می\u200Cرود\"},{\"Id\":\"401\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Intel-Rocket-Lake-S.jpg\",\"Title\":\"پردازنده نسل یازدهمی Rocket Lake-S اینتل دیده شد\"},{\"Id\":\"398\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/ufYa6owMdabMGN88yFyQNa-650-80.jpg\",\"Title\":\"نیمی از پرسنل فیس\u200Cبوک تا ده سال دیگر دورکار می\u200Cشوند\"},{\"Id\":\"395\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/eye-1.jpg\",\"Title\":\"ساخت چشم مصنوعی بیولوژیکی که دارای نزدیک\u200Cترین ساختار به چشم طبیعی انسان است\"},{\"Id\":\"393\",\"Image\":\"\",\"Title\":\"با قابلیت جدید اینستاگرام به صورت همزمان با 50 نفر ویدئو چت کنید\"},{\"Id\":\"390\",\"Image\":\"\",\"Title\":\"11 پلاگین برتر برای تبدیل وبسایت وردپرسی به اپلیکیشن موبایل\"},{\"Id\":\"387\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/SAMMI.jpg\",\"Title\":\"سامسونگ با تاسیس یک کارخانه جدید رقابت تازه\u200C\u200Cای را با TSMC شروع می\u200Cکند\"},{\"Id\":\"383\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Apple-Glass.jpg\",\"Title\":\"قیمت و تاریخ عرضه عینک واقعیت افزوده Apple Glass مشخص شد\"},{\"Id\":\"380\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/shad1585.jpg\",\"Title\":\"وعده معاون وزیر ICT: اگر فرکانس\u200Cهای 700 و 800 از سوی صدا و سیما آزاد شود به دانش\u200Cآموزان اینترنت رایگان می\u200Cدهیم!\"},{\"Id\":\"377\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/te-6.jpg\",\"Title\":\"سامسونگ از گوشی جان سخت Galaxy S20 Tactical Edition رونمایی کرد؛ خاص عملیات نظامی با ویژگی\u200Cهای هیجان\u200Cانگیز\"},{\"Id\":\"374\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/pixel-5-soli-motion-sense-2.jpg\",\"Title\":\"یک تجربه ناموفق دیگر برای گوگل؛ گوشی پیکسل 5 از فناوری جذاب Motion Sense محروم ماند\"},{\"Id\":\"371\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/2020-05-18-image-35.jpg\",\"Title\":\"درخواست مقامات آمریکایی برای دسترسی به اطلاعات تلفن\u200Cهای همراه پس از قفل گشایی گوشی\u200Cهای آیفون متهمین\"},{\"Id\":\"369\",\"Image\":\"\",\"Title\":\"فعال سازی God Mode در ویندوز 10\"},{\"Id\":\"366\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/c2c.jpg\",\"Title\":\"بازگشت سقف تراکنش\u200Cهای بانکی به مقادیر قبلی، از اول خرداد ماه\"},{\"Id\":\"363\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/2004.jpg\",\"Title\":\"با نسخه جدید ویندوز 10 می\u200Cتوانید اسپیکر معمولی خود را به اسپیکر بی سیم تبدیل کنید\"},{\"Id\":\"360\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/rrj.jpg\",\"Title\":\"آیا سیستم مدیریت بندر شهید رجایی هدف حمله سایبری اسرائیل قرار گرفته است؟\"},{\"Id\":\"357\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/cloud.jpg\",\"Title\":\"خودکفایی ایران در حوزه تولید زیرساخت خدمات ابری\"},{\"Id\":\"354\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/feta-police.jpg\",\"Title\":\"هشدار پلیس فتا در خصوص کارت\u200Cهای بانکی اجاره\u200Cای؛ بیشتر کلاه\u200Cبردارها جوان و نوجوان هستند\"},{\"Id\":\"351\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/majles.jpg\",\"Title\":\"استفاده از سخت افزار و نرم افزار محصول اسرائیل ممنوع شد (+مجازات)\"},{\"Id\":\"348\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/sony-intelligent-sensor.jpeg\",\"Title\":\"سونی اولین سنسور هوشمند بینایی با پردازنده آنبرد هوش\u200Cمصنوعی را ساخت\"},{\"Id\":\"345\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/000HU-03.jpg\",\"Title\":\"هوآوی با لپ\u200Cتاپ جدید Honor MagicBook Pro 2020 به نبرد با حرفه\u200Cای\u200Cها می رود\"},{\"Id\":\"342\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/ap_resiz.jpg\",\"Title\":\"پرونده انحصارگرایی گوگل توسط وزارت دادگستری ایالات متحده در دست بررسی است\"},{\"Id\":\"339\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Xiaomi.jpg\",\"Title\":\"مدیرعامل شیائومی رسوایی به بار آورد\"},{\"Id\":\"336\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/apple-iphone-7-1024x576-1.jpg\",\"Title\":\"جریمه نیم میلیارد دلاری اپل به جرم کاهش سرعت گوشی\u200Cهای آیفون\"},{\"Id\":\"333\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/huawei-us.jpg\",\"Title\":\"درخواست چین از آمریکا برای توقف فشارهای غیرمنطقی وارد بر هواوی\"},{\"Id\":\"329\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/nni.jpg\",\"Title\":\"هزینه تمام شده شبکه ملی اطلاعات تا به امروز را حدس بزنید\"},{\"Id\":\"326\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/money.jpg\",\"Title\":\"توصیه «رئیس کمیته تخصصی تلفن همراه کشور»: یک ماه گوشی نخرید!\"},{\"Id\":\"323\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/gsmarena_0302.jpg\",\"Title\":\"با Galaxy A Quantum آشنا شوید؛ اولین گوشی جهان با فناوری رمزگذاری کوانتومی\"},{\"Id\":\"318\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/ex-4.jpg\",\"Title\":\"منتظر چیپست جدید میان\u200Cرده رو به بالای سامسونگ باشید؛ رقیبی جدی برای کوالکام و هواوی\"},{\"Id\":\"315\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/33434.jpg\",\"Title\":\"بروزرسانی اندروید 10 برای کاربران ایرانی گوشی نوکیا 3.1 پلاس عرضه شد\"},{\"Id\":\"312\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/s20ultra.jpg\",\"Title\":\"محبوب\u200Cترین گوشی کاربران ایرانی کدام است؟\"},{\"Id\":\"309\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/aaalien-05.jpg\",\"Title\":\"از ارزان قیمت تا فوق حرفه\u200Cای؛ لپ\u200Cتاپ\u200Cهای گیمینگ Dell و Alienware معرفی شدند\"},{\"Id\":\"305\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/unnamed.jpg\",\"Title\":\"6 اپلیکیشن و پلاگین برای تمرکز بیشتر هنگام دورکاری در خانه\"},{\"Id\":\"302\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/3.jpg\",\"Title\":\"گوشی\u200Cهای ارزان قیمت Nokia 125 و Nokia 150 معرفی شدند\"},{\"Id\":\"299\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/4855485.jpg\",\"Title\":\"13 توصیه مهم در استفاده از گوشی موبایل هنگام وقوع زلزله و شرایط اضطراری\"},{\"Id\":\"296\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/wing2.jpg\",\"Title\":\"گوشی جدید ال\u200Cجی با نمایشگر چرخان لمسی عرضه می\u200Cشود\"},{\"Id\":\"292\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/GLX-Arye.jpg\",\"Title\":\"آیا باید منتظر افزایش عرضه گوشی ایرانی باشیم؟\"},{\"Id\":\"287\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/ps5_concept_1.jpg\",\"Title\":\"سونی دو کنسول «پلی استیشن 5» متفاوت را روانه بازار می\u200Cکند؛ تفاوت آنها در چیست؟\"},{\"Id\":\"282\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/sm.jpg\",\"Title\":\"وضعیت این روزهای بازار موبایل کشور؛ آیا با احتکاری بزرگ روبرو هستیم؟\"},{\"Id\":\"266\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/6.png\",\"Title\":\"جلسه بیستم کنترل خطا ها\"},{\"Id\":\"263\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/TCL-X915-2.jpg\",\"Title\":\"تلویزیون مدرن و پیشرفته TCL X915 با وضوح 8K و اندروید تی\u200Cوی راهی بازار شد\"},{\"Id\":\"260\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/XBOXXX-2.jpg\",\"Title\":\"کدام کنسول ارزان\u200Cتر خواهد بود؟ Xbox Series X یا PlayStation 5؟\"},{\"Id\":\"257\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/The-Nokia-9.3-PureView-5G-could-do-something-not-many-phones-can.jpg\",\"Title\":\"گوشی پرچمدار نوکیا 9.3 از قابلیت فیلم\u200Cبرداری با رزولوشن 8K پشتیبانی می\u200Cکند\"},{\"Id\":\"245\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/ssss.png\",\"Title\":\"جلسه نوزدهم استفاده از چند نخی در برنامه\"},{\"Id\":\"242\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Samsung-a-800x503-1.jpg\",\"Title\":\"سامسونگ، شیائومی و چند برند چینی دیگر تولیدات خود را در هندوستان از سر می\u200Cگیرند\"},{\"Id\":\"239\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/XEON-06.jpg\",\"Title\":\"ترکیب بسیار قدرتمند کارت گرافیک NVIDIA Quadro با پردازنده Intel Xeon W دیده شدند\"},{\"Id\":\"235\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/iphone-12.jpg\",\"Title\":\"آخرین اطلاعات لو رفته از آیفون 12؛ از طراحی جدید تا نمایشگر 120 هرتزی\"},{\"Id\":\"231\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/sd768-1.jpg\",\"Title\":\"اسنپدراگون 768G؛ مشخصات یک چیپست جذاب کوالکام فاش شد\"},{\"Id\":\"228\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/low.jpg\",\"Title\":\"عدم رضایت 87 درصدی کاربران از سرعت اینترنت؛ آمار باورنکردنی عملکرد اپراتورها\"},{\"Id\":\"225\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/26dd54b4-9099-4e12-8f8b-5a88862bef6b.jpeg\",\"Title\":\"کرونا، کارمندان فیس\u200C بوک و گوگل را تا پایان سال به دورکاری فرستاد\"},{\"Id\":\"221\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/irankey.jpg\",\"Title\":\"ورود مجلس به موضوع دو پروژه شبکه ملی اطلاعات و دولت الکترونیک و ارزیابی آنها\"},{\"Id\":\"218\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/2020_02_18_86883_1582002366._large.jpg\",\"Title\":\"پرفروش\u200Cترین گوشی سامسونگ در سال 2020 کدام بوده است؟\"},{\"Id\":\"215\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Glyph-Icon-hero.png\",\"Title\":\"اینستاگرام به زودی امکان فوروارد کردن پیام\u200Cهای دایرکت را در اختیار کاربران می\u200Cگذارد\"},{\"Id\":\"202\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Untitled-3.png\",\"Title\":\"جلسه هیجدهم استفاده از Switch و Case\"},{\"Id\":\"196\",\"Image\":\"\",\"Title\":\"جلسه هیجدهم استفاده از توابع ریاضی آماده\"},{\"Id\":\"193\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Untitled-1.png\",\"Title\":\"جلسه هفدهم توابع\"},{\"Id\":\"188\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Screenshot-from-2020-05-04-13-25-55.png\",\"Title\":\"جلسه شانزدهم عملگر شرطی سه تایی\"},{\"Id\":\"182\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Screenshot-from-2020-05-03-14-57-30.png\",\"Title\":\"جلسه پانزدهم انواع عملیات روی رشته ها\"},{\"Id\":\"178\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Screenshot-from-2020-05-02-22-07-41.png\",\"Title\":\"جلسه چهاردهم لیست\"},{\"Id\":\"166\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Screenshot-from-2020-05-02-18-22-59.png\",\"Title\":\"جلسه سیزدهم آرایه ها\"},{\"Id\":\"158\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/c-1.png\",\"Title\":\"جلسه دوازدهم حلقه do-while\"},{\"Id\":\"151\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/rr.png\",\"Title\":\"جلسه یازدهم حلقه while\"},{\"Id\":\"145\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/Screenshot-from-2020-05-01-12-11-53.png\",\"Title\":\"جلسه دهم حلقه for\"},{\"Id\":\"138\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/login.png\",\"Title\":\"جلسه نهم منطق در جاوا\"},{\"Id\":\"135\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/18.png\",\"Title\":\"جلسه هشتم عمل های اصلی در جاوا\"},{\"Id\":\"124\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/16.png\",\"Title\":\"جلسه هفتم شرط گذاری\"},{\"Id\":\"119\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/05\\/11.png\",\"Title\":\"جلسه ششم مقدار دهی عددی به متغیر های عددی\"},{\"Id\":\"110\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/04\\/Screenshot-from-2020-04-29-22-50-26.png\",\"Title\":\"جلسه پنجم جاوا بازنویسی جلسه سوم\"},{\"Id\":\"85\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/04\\/6.png\",\"Title\":\"جلسه چهارم جاوا متغییر ها\"},{\"Id\":\"70\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/04\\/2.png\",\"Title\":\"جلسه سوم جاوا دریافت اسم از کاربر و سلام کردن به آن\"},{\"Id\":\"58\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/04\\/Screenshot-from-2020-04-27-20-50-37.png\",\"Title\":\"جلسه دوم سلام دنیا\"},{\"Id\":\"18\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/04\\/Screenshot-from-2020-04-29-11-05-29.png\",\"Title\":\"شروع جاوا\"},{\"Id\":\"1\",\"Image\":\"http:\\/\\/www.sorapp.ir\\/wp-content\\/uploads\\/2020\\/04\\/Screenshot-from-2020-04-26-22-24-14.png\",\"Title\":\"جلسه اول آموزش برنامه نویسی جاوا\"},{\"Id\":\"563\",\"Image\":\"\",\"Title\":\"پیش\u200Cنویس خودکار\"}]");
//            Cls_Main.GET_CATEGORYS_BY_JSON("[{\"Id\":\"1\",\"Name\":\"مطالب روز\"},{\"Id\":\"2\",\"Name\":\"آموزش جاوا\"}]");
//            GET_CHECK_SIGN_USER();
//        }
//        catch (Exception Err)
//        {
//
//        }
//        startActivity(new Intent(getApplicationContext(), ac_main.class));

//        GET_CHECK_SIGN_USER();
        GET_START();
        Timer_Start();
    }
/*-------------------------------------------------------------------------------------*/
    //Get Data From Server Start
    public void GET_START()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    Cls_Main.GET_VERSION();
                }
                catch (Exception Err)
                {

                }
            }
        }).start();
    }
    //Get Data From Server End
/*-------------------------------------------------------------------------------------*/
    //TIMER FOR CHECK FILL ALL Feilds Start
    public void Timer_Start()
    {
        Internet=isInternetConnection();
        timer = new CountDownTimer(600000, 10)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                if (!Changed_Ac)
                {
                    try
                    {
                        if(Internet)
                        {
                            CHECK_ALL_VALUES();
                        }
                        else
                        {
                            startActivity(new Intent(getApplicationContext(),ac_no_internet.class));
                            Changed_Ac=true;
                        }
                    }
                    catch (Exception Err)
                    {

                    }
                }
            }

            @Override
            public void onFinish()
            {

            }
        }.start();
    }
    //TIMER FOR CHECK FILL ALL Feilds End
/*-------------------------------------------------------------------------------------*/
    //Get Check All Values For Start,Start
    public void CHECK_ALL_VALUES()throws Exception
    {
        if (!Cls_Main.Version_Code.equals(""))
        {
            try
            {
                PackageInfo Pack = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
                String Version = Pack.versionCode + "";

                if (Version.trim().equals(Cls_Main.Version_Code.trim()))
                {
                    if(GET_CHECK_SIGN_USER())
                    {
                        if(GET_LOG_CONDITION())
                        {
                            Main_Activity_Start();
                        }
                    }
                }
                else
                {
                    Changed_Ac = true;
                    startActivity(new Intent(getApplicationContext(), ac_most_update.class));
                }
            }
            catch (Exception Err)
            {

            }
        }
    }
    //Get Check All Values For Start,End
/*-------------------------------------------------------------------------------------*/
    //Get Check Sign User Start
    public boolean GET_CHECK_SIGN_USER()
    {
        SharedPreferences editor=getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        if(editor.getString("ID","").trim()!="")
        {
            Cls_Main.USER_ID=editor.getString("ID","").trim();
            Cls_Main.USER_EMAIL=editor.getString("Email","").trim();
            Cls_Main.PHONE=editor.getString("Phone","").trim();
            return true;
        }
        else
        {
            Changed_Ac = true;
            startActivity(new Intent(getApplicationContext(), ac_sign_in.class));
        }
        return false;
    }
    //Get Check Sign User End
/*-----------------------------------------------------------------------------------*/
    //Get Start Main Activity Start
    public void Main_Activity_Start()
    {
        timer.cancel();
        Changed_Ac = true;
        startActivity(new Intent(getApplicationContext(), ac_main.class));
    }
    //Get Start Main Activity End
/*-------------------------------------------------------------------------------------*/
    //Internet Conntion Check Start
    public  boolean isInternetConnection()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    //Internet Conntion Check End
/*-------------------------------------------------------------------------------------*/
    //Check Log Condition Start
    public boolean GET_LOG_CONDITION()
    {
        if(Cls_Main.Log_Condition.trim().equals(""))
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try {
                        Cls_Main.LOG(Cls_Main.USER_ID);
                    } catch (Exception Err)
                    {
                    }
                }
            }).start();

            Timier2 = new CountDownTimer(600000, 10) {
                @Override
                public void onTick(long millisUntilFinished)
                {
                    try
                    {
                        if (!Cls_Main.Log_Condition.equals(""))
                        {

                            Log.i("Errt",Cls_Main.Log_Condition);

                            if (Cls_Main.Log_Condition.trim().equals("NOT_FOUND"))
                            {
                                startActivity(new Intent(getApplicationContext(), ac_notfound_user.class));
                                Log_Condition=true;
                                CONDITION=false;
                            }
                            else if(Cls_Main.Log_Condition.trim().equals("LIMITED_OF_SERVER"))
                            {
                                startActivity(new Intent(getApplicationContext(),ac_limit_of_server.class));
                                Log_Condition=true;
                                CONDITION=false;
                            }
                            else if(Cls_Main.Log_Condition.trim().equals("Access_Is_Limited"))
                            {
                                startActivity(new Intent(getApplicationContext(),ac_limit_user.class));
                                Log_Condition=true;
                                CONDITION=false;
                            }
                            else if(Cls_Main.Log_Condition.trim().equals("Server_Is_FIXING"))
                            {
                                startActivity(new Intent(getApplicationContext(),ac_server_is_fixing.class));
                                Log_Condition=true;
                                CONDITION=false;
                            }
                            else if (Cls_Main.Log_Condition.trim().equals("Welcome"))
                            {
                                Log_Condition=true;
                                CONDITION=true;
                            }
                            GET_SERVER_DATA();

                            Timier2.cancel();
                        }
                    }
                    catch (Exception Err)
                    {

                    }
                }
                @Override
                public void onFinish() {

                }
            }.start();
        }
        return CONDITION;
    }
    //Check Log Condition End
/*-------------------------------------------------------------------------------------*/
    //GET SERVER Start
    public void GET_SERVER_DATA()
    {
        for(int a=0;a<RETERY_GET_DATA;a++)
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                {
                    //GET All Data Start
                    try
                    {
                        Cls_Main.GET_ALL_POSTS();
                        Cls_Main.GET_CATEGORYS();
                        Cls_Main.GET_USER_PROFILE(Cls_Main.USER_ID);
                    }
                    catch (Exception Err)
                    {

                    }
                    //GET All Data End
                }
                    }
        }).start();
    }
    //GET SERVER End
/*-------------------------------------------------------------------------------------*/


}
