package in.etuwa.app.ui.push;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import in.etuwa.app.R;
import in.etuwa.app.data.db.MyDataBase;
import in.etuwa.app.databinding.ActivityPushBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.assignment.AssignmentFragment;
import in.etuwa.app.ui.base.BaseActivity;
import in.etuwa.app.ui.calendar.CalendarFragment;
import in.etuwa.app.ui.counselling.CounsellingFragment;
import in.etuwa.app.ui.dashboard.DashboardFragment;
import in.etuwa.app.ui.exam.module.ModuleTestFragment;
import in.etuwa.app.ui.exam.series.SeriesExamFragment;
import in.etuwa.app.ui.grievance.GrievanceFragment;
import in.etuwa.app.ui.homework.HomeWorkFragment;
import in.etuwa.app.ui.internship.InternshipFragment;
import in.etuwa.app.ui.message.inbox.MessageFragment;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

/* compiled from: PushActivity.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\u0012\u0010%\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020\u0016H\u0016J\b\u0010)\u001a\u00020\u0016H\u0016J\b\u0010*\u001a\u00020\u0016H\u0014J\b\u0010+\u001a\u00020\u0016H\u0014J\b\u0010,\u001a\u00020\u0016H\u0016J\b\u0010-\u001a\u00020\u0016H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lin/etuwa/app/ui/push/PushActivity;", "Lin/etuwa/app/ui/base/BaseActivity;", "Lin/etuwa/app/ui/push/PushAdapter$CallBack;", "()V", "adapter", "Lin/etuwa/app/ui/push/PushAdapter;", "getAdapter", "()Lin/etuwa/app/ui/push/PushAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "Lin/etuwa/app/databinding/ActivityPushBinding;", "dataBase", "Lin/etuwa/app/data/db/MyDataBase;", "getDataBase", "()Lin/etuwa/app/data/db/MyDataBase;", "dataBase$delegate", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "manager", "Landroidx/fragment/app/FragmentManager;", "assignments", "", "assignmentsresults", "counselling", "grievance", "hideProgress", "homeworks", "internal", "internship", "loadBottomItems", "fragment", "Landroidx/fragment/app/Fragment;", "material", "moduletest", "moduletestresult", "notice", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "seriesexam", "seriesexamresults", "setUp", "showProgress", "tutorial", "tutorialresult", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushActivity extends BaseActivity implements PushAdapter.CallBack {

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ActivityPushBinding binding;

    /* renamed from: dataBase$delegate, reason: from kotlin metadata */
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
        ActivityPushBinding activityPushBinding3 = this.binding;
        if (activityPushBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPushBinding3 = null;
        }
        activityPushBinding3.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { // from class: in.etuwa.app.ui.push.PushActivity$$ExternalSyntheticLambda0
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean up$lambda$0;
                up$lambda$0 = PushActivity.setUp$lambda$0(PushActivity.this, menuItem);
                return up$lambda$0;
            }
        });
        getAdapter().addItems(getDataBase().queryMessages());
        try {
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new PushActivity$setUp$swipeHandler$1(this));
            ActivityPushBinding activityPushBinding4 = this.binding;
            if (activityPushBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityPushBinding2 = activityPushBinding4;
            }
            itemTouchHelper.attachToRecyclerView(activityPushBinding2.rvPush);
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setUp$lambda$0(PushActivity this$0, MenuItem it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        int itemId = it.getItemId();
        if (itemId == R.id.action_home) {
            this$0.loadBottomItems(DashboardFragment.INSTANCE.newInstance(0));
            return true;
        }
        if (itemId == R.id.action_calender) {
            this$0.loadBottomItems(CalendarFragment.INSTANCE.newInstance());
            return true;
        }
        if (itemId != R.id.action_message) {
            return true;
        }
        this$0.loadBottomItems(MessageFragment.INSTANCE.newInstance());
        return true;
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
        FragmentTransaction beginTransaction = fragmentManager3.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "manager.beginTransaction()");
        beginTransaction.add(R.id.push_layout, fragment);
        beginTransaction.addToBackStack(null);
        beginTransaction.commitAllowingStateLoss();
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(assignmentFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof AssignmentFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(assignmentResultFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof AssignmentResultFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(seriesExamFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof SeriesExamFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(sessionalFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof SessionalFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(homeWorkFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof HomeWorkFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(moduleTestFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof ModuleTestFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(materialFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof MaterialFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(noticeFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof NoticeFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(tutorialFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof TutorialFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(tutorialResultFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof TutorialResultFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(internalResultFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof InternalResultFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(grievanceFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof GrievanceFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(counsellingFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof CounsellingFragment) || supportFragmentManager.isDestroyed()) {
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
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(internshipFragment.getClass().getSimpleName());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if ((findFragmentByTag instanceof InternshipFragment) || supportFragmentManager.isDestroyed()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.push_layout, internshipFragment, "InternshipFragment").commit();
    }
}