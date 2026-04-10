package in.etuwa.app.ui.push;

import android.content.ComponentCallbacks;
import android.content.Intent;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.R;
import in.etuwa.app.data.db.MyDataBase;
import in.etuwa.app.databinding.ActivityPushBinding;
import in.etuwa.app.ui.base.BaseActivity;
import in.etuwa.app.ui.main.MainActivity;
import in.etuwa.app.ui.push.PushAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

/* JADX INFO: compiled from: NotificationActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationActivity extends BaseActivity implements PushAdapter.CallBack {

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ActivityPushBinding binding;

    /* JADX INFO: renamed from: dataBase$delegate, reason: from kotlin metadata */
    private final Lazy dataBase;

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void assignments() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void assignmentsresults() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void counselling() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void grievance() {
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void homeworks() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void internal() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void internship() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void material() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void moduletest() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void moduletestresult() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void notice() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void seriesexam() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void seriesexamresults() {
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void showProgress() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void tutorial() {
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void tutorialresult() {
    }

    public NotificationActivity() {
        final NotificationActivity notificationActivity = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<PushAdapter>() { // from class: in.etuwa.app.ui.push.NotificationActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.push.PushAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PushAdapter invoke() {
                ComponentCallbacks componentCallbacks = notificationActivity;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(PushAdapter.class), qualifier, b);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.dataBase = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<MyDataBase>() { // from class: in.etuwa.app.ui.push.NotificationActivity$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.db.MyDataBase, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MyDataBase invoke() {
                ComponentCallbacks componentCallbacks = notificationActivity;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(MyDataBase.class), b2, b3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PushAdapter getAdapter() {
        return (PushAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MyDataBase getDataBase() {
        return (MyDataBase) this.dataBase.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02a2  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onCreate(android.os.Bundle r10) {
        /*
            Method dump skipped, instruction units count: 1530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.push.NotificationActivity.onCreate(android.os.Bundle):void");
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void setUp() {
        setTitle(getString(R.string.notification));
        ActivityPushBinding activityPushBinding = this.binding;
        ActivityPushBinding activityPushBinding2 = null;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setAdapter(getAdapter());
        getAdapter().addItems(getDataBase().queryMessages());
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new NotificationActivity$setUp$swipeHandler$1(this));
        ActivityPushBinding activityPushBinding3 = this.binding;
        if (activityPushBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityPushBinding2 = activityPushBinding3;
        }
        itemTouchHelper.attachToRecyclerView(activityPushBinding2.rvPush);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openMain(int index) {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra("bottom_index", index);
        intent.setFlags(131072);
        startActivity(intent);
        finish();
    }
}