package in.etuwa.app.ui.push;

import android.content.ComponentCallbacks;
import androidx.recyclerview.widget.ItemTouchHelper;
import in.etuwa.app.R;
import in.etuwa.app.data.db.MyDataBase;
import in.etuwa.app.databinding.ActivityPushBinding;
import in.etuwa.app.ui.base.BaseActivity;
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

/* compiled from: NotificationActivity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020\u0012H\u0014J\b\u0010$\u001a\u00020\u0012H\u0014J\b\u0010%\u001a\u00020\u0012H\u0016J\b\u0010&\u001a\u00020\u0012H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000f¨\u0006'"}, d2 = {"Lin/etuwa/app/ui/push/NotificationActivity;", "Lin/etuwa/app/ui/base/BaseActivity;", "Lin/etuwa/app/ui/push/PushAdapter$CallBack;", "()V", "adapter", "Lin/etuwa/app/ui/push/PushAdapter;", "getAdapter", "()Lin/etuwa/app/ui/push/PushAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "Lin/etuwa/app/databinding/ActivityPushBinding;", "dataBase", "Lin/etuwa/app/data/db/MyDataBase;", "getDataBase", "()Lin/etuwa/app/data/db/MyDataBase;", "dataBase$delegate", "assignments", "", "assignmentsresults", "counselling", "grievance", "hideProgress", "homeworks", "internal", "internship", "material", "moduletest", "moduletestresult", "notice", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "seriesexam", "seriesexamresults", "setUp", "showProgress", "tutorial", "tutorialresult", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationActivity extends BaseActivity implements PushAdapter.CallBack {

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ActivityPushBinding binding;

    /* renamed from: dataBase$delegate, reason: from kotlin metadata */
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

    /* JADX WARN: Removed duplicated region for block: B:105:0x0289 A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02d7 A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0325 A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0373 A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03c1 A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x040f A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x045d A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x04ab A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04f9 A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0547 A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0593 A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x05c4 A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb A[Catch: NullPointerException -> 0x05dd, TRY_ENTER, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0107 A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0153 A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019f A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ed A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x023b A[Catch: NullPointerException -> 0x05dd, TryCatch #0 {NullPointerException -> 0x05dd, blocks: (B:6:0x0026, B:8:0x0030, B:9:0x0038, B:12:0x0050, B:14:0x0059, B:18:0x006a, B:20:0x0083, B:26:0x00a0, B:28:0x00a9, B:33:0x00bb, B:35:0x00d4, B:39:0x00ed, B:41:0x00f6, B:45:0x0107, B:47:0x0120, B:51:0x013b, B:53:0x0144, B:57:0x0153, B:59:0x016c, B:63:0x0185, B:65:0x018e, B:69:0x019f, B:71:0x01b8, B:75:0x01d3, B:77:0x01dc, B:81:0x01ed, B:83:0x0206, B:87:0x0221, B:89:0x022a, B:93:0x023b, B:95:0x0254, B:99:0x026f, B:101:0x0278, B:105:0x0289, B:107:0x02a2, B:111:0x02bd, B:113:0x02c6, B:117:0x02d7, B:119:0x02f0, B:123:0x030b, B:125:0x0314, B:129:0x0325, B:131:0x033e, B:135:0x0359, B:137:0x0362, B:141:0x0373, B:143:0x038c, B:147:0x03a7, B:149:0x03b0, B:153:0x03c1, B:155:0x03da, B:159:0x03f5, B:161:0x03fe, B:165:0x040f, B:167:0x0428, B:171:0x0443, B:173:0x044c, B:177:0x045d, B:179:0x0476, B:183:0x0491, B:185:0x049a, B:189:0x04ab, B:191:0x04c4, B:195:0x04df, B:197:0x04e8, B:201:0x04f9, B:203:0x0512, B:207:0x052d, B:209:0x0536, B:213:0x0547, B:215:0x0560, B:219:0x057a, B:221:0x0583, B:225:0x0593, B:227:0x05ac, B:230:0x05c4, B:232:0x05d7, B:233:0x05da), top: B:5:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x026d  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onCreate(android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 1502
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
}