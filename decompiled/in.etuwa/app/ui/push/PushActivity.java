package in.etuwa.app.ui.push;

import android.content.ComponentCallbacks;
import android.content.Intent;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.R;
import in.etuwa.app.data.db.MyDataBase;
import in.etuwa.app.databinding.ActivityPushBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.assignment.AssignmentFragment;
import in.etuwa.app.ui.base.BaseActivity;
import in.etuwa.app.ui.counselling.CounsellingFragment;
import in.etuwa.app.ui.exam.module.ModuleTestFragment;
import in.etuwa.app.ui.exam.series.SeriesExamFragment;
import in.etuwa.app.ui.grievance.GrievanceFragment;
import in.etuwa.app.ui.homework.HomeWorkFragment;
import in.etuwa.app.ui.internship.InternshipFragment;
import in.etuwa.app.ui.main.MainActivity;
import in.etuwa.app.ui.notice.NoticeFragment;
import in.etuwa.app.ui.push.PushAdapter;
import in.etuwa.app.ui.result.assignment.AssignmentResultFragment;
import in.etuwa.app.ui.result.internal.InternalResultFragment;
import in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment;
import in.etuwa.app.ui.result.session.SessionalFragment;
import in.etuwa.app.ui.result.tutorials.TutorialResultFragment;
import in.etuwa.app.ui.studymaterials.MaterialFragment;
import in.etuwa.app.ui.tutorial.TutorialFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.ibrahimsn.lib.SmoothBottomBar;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

/* JADX INFO: compiled from: PushActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class PushActivity extends BaseActivity implements PushAdapter.CallBack {

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ActivityPushBinding binding;

    /* JADX INFO: renamed from: dataBase$delegate, reason: from kotlin metadata */
    private final Lazy dataBase;
    private MainCallBackListener listener;
    private FragmentManager manager;

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void showProgress() {
    }

    public PushActivity() {
        final PushActivity pushActivity = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<PushAdapter>() { // from class: in.etuwa.app.ui.push.PushActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.push.PushAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PushAdapter invoke() {
                ComponentCallbacks componentCallbacks = pushActivity;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(PushAdapter.class), qualifier, b);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.dataBase = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<MyDataBase>() { // from class: in.etuwa.app.ui.push.PushActivity$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.db.MyDataBase, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MyDataBase invoke() {
                ComponentCallbacks componentCallbacks = pushActivity;
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_push);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(this, R.layout.activity_push)");
        ActivityPushBinding activityPushBinding = (ActivityPushBinding) contentView;
        this.binding = activityPushBinding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.setLifecycleOwner(this);
        setUp();
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
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        this.manager = supportFragmentManager;
        getAdapter().setCallBack(this);
        SmoothBottomBar smoothBottomBar = (SmoothBottomBar) findViewById(R.id.bottom_nav_new);
        smoothBottomBar.setOnItemSelected(new Function1<Integer, Unit>() { // from class: in.etuwa.app.ui.push.PushActivity.setUp.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                if (i != 0) {
                    PushActivity.this.openMain(i);
                } else {
                    PushActivity.this.finish();
                }
            }
        });
        smoothBottomBar.setOnItemReselected(new Function1<Integer, Unit>() { // from class: in.etuwa.app.ui.push.PushActivity.setUp.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                if (i != 0) {
                    PushActivity.this.openMain(i);
                } else {
                    PushActivity.this.finish();
                }
            }
        });
        getAdapter().addItems(getDataBase().queryMessages());
        try {
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new PushActivity$setUp$swipeHandler$1(this));
            ActivityPushBinding activityPushBinding3 = this.binding;
            if (activityPushBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityPushBinding2 = activityPushBinding3;
            }
            itemTouchHelper.attachToRecyclerView(activityPushBinding2.rvPush);
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private final void loadBottomItems(Fragment fragment) {
        FragmentManager fragmentManager = this.manager;
        if (fragmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager = null;
        }
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager fragmentManager2 = this.manager;
            if (fragmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manager");
                fragmentManager2 = null;
            }
            fragmentManager2.popBackStack();
        }
        FragmentManager fragmentManager3 = this.manager;
        if (fragmentManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manager");
            fragmentManager3 = null;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager3.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "manager.beginTransaction()");
        fragmentTransactionBeginTransaction.add(R.id.push_layout, fragment);
        fragmentTransactionBeginTransaction.addToBackStack(null);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void assignments() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        AssignmentFragment assignmentFragment = new AssignmentFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(assignmentFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof AssignmentFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, assignmentFragment, "AssignmentFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void assignmentsresults() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        AssignmentResultFragment assignmentResultFragment = new AssignmentResultFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(assignmentResultFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof AssignmentResultFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, assignmentResultFragment, "AssignmentResultFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void seriesexam() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        SeriesExamFragment seriesExamFragment = new SeriesExamFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(seriesExamFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof SeriesExamFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, seriesExamFragment, "SeriesExamFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void seriesexamresults() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        SessionalFragment sessionalFragment = new SessionalFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(sessionalFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof SessionalFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, sessionalFragment, "SessionalFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void homeworks() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        HomeWorkFragment homeWorkFragment = new HomeWorkFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(homeWorkFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof HomeWorkFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, homeWorkFragment, "HomeWorkFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void moduletest() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        ModuleTestFragment moduleTestFragment = new ModuleTestFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(moduleTestFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof ModuleTestFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, moduleTestFragment, "ModuleTestFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void moduletestresult() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        ResultModuleTestFragment resultModuleTestFragment = new ResultModuleTestFragment();
        if ((getSupportFragmentManager().findFragmentByTag(resultModuleTestFragment.getClass().getSimpleName()) instanceof ResultModuleTestFragment) || getFragmentManager().isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, resultModuleTestFragment, "ResultModuleTestFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void material() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        MaterialFragment materialFragment = new MaterialFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(materialFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof MaterialFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, materialFragment, "MaterialFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void notice() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        NoticeFragment noticeFragment = new NoticeFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(noticeFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof NoticeFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, noticeFragment, "NoticeFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void tutorial() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        TutorialFragment tutorialFragment = new TutorialFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(tutorialFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof TutorialFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, tutorialFragment, "TutorialFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void tutorialresult() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        TutorialResultFragment tutorialResultFragment = new TutorialResultFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(tutorialResultFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof TutorialResultFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, tutorialResultFragment, "TutorialResultFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void internal() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        InternalResultFragment internalResultFragment = new InternalResultFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(internalResultFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof InternalResultFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, internalResultFragment, "InternalResultFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void grievance() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        GrievanceFragment grievanceFragment = new GrievanceFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(grievanceFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof GrievanceFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, grievanceFragment, "GrievanceFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void counselling() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        CounsellingFragment counsellingFragment = new CounsellingFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(counsellingFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof CounsellingFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, counsellingFragment, "CounsellingFragment").commit();
    }

    @Override // in.etuwa.app.ui.push.PushAdapter.CallBack
    public void internship() {
        ActivityPushBinding activityPushBinding = this.binding;
        if (activityPushBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding = null;
        }
        activityPushBinding.rvPush.setVisibility(8);
        InternshipFragment internshipFragment = new InternshipFragment();
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(internshipFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((fragmentFindFragmentByTag instanceof InternshipFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, internshipFragment, "InternshipFragment").commit();
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