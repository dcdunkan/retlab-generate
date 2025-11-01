package in.etuwa.app.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.dashboard.DashboardAdapter;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* compiled from: DashboardAdapter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\"#B\u0005¢\u0006\u0002\u0010\u0004J6\u0010\u0013\u001a\u00020\u00142\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0006j\b\u0012\u0004\u0012\u00020\u0012`\b2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bJ\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0006j\b\u0012\u0004\u0012\u00020\u0012`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lin/etuwa/app/ui/dashboard/DashboardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "Lorg/koin/core/component/KoinComponent;", "()V", "iconList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/dashboard/DashboardAdapter$CallBack;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "titleList", "", "addItems", "", "dashTitleList", "iconTitleList", "getItemCount", "onBindViewHolder", "holder", CommonCssConstants.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/dashboard/DashboardFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DashboardAdapter extends RecyclerView.Adapter<BaseViewHolder> implements KoinComponent {
    private final ArrayList<Integer> iconList;
    private CallBack listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private final ArrayList<String> titleList;

    /* compiled from: DashboardAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/dashboard/DashboardAdapter$CallBack;", "", "onDashItemClicked", "", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void onDashItemClicked(int position);
    }

    public DashboardAdapter() {
        final DashboardAdapter dashboardAdapter = this;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.dashboard.DashboardAdapter$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                Scope rootScope;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = b;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier2, function0);
            }
        });
        this.titleList = new ArrayList<>();
        this.iconList = new ArrayList<>();
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_dash, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   ….row_dash, parent, false)");
        return new ViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size;
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gcek", false, 2, (Object) null)) {
            size = this.titleList.size();
        } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "nssce", false, 2, (Object) null)) {
            size = this.titleList.size();
        } else {
            if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mcet", false, 2, (Object) null)) {
                return this.titleList.size() - 4;
            }
            if (!StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace", false, 2, (Object) null)) {
                if (!StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sbce", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sahrdaya", false, 2, (Object) null)) {
                    if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea", false, 2, (Object) null)) {
                        size = this.titleList.size();
                    } else {
                        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null)) {
                            return this.titleList.size();
                        }
                        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "aisat", false, 2, (Object) null)) {
                            size = this.titleList.size();
                        } else {
                            if (!StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mea", false, 2, (Object) null)) {
                                if (!StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tmc", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mits", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "vjec.", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "ukfcet.", false, 2, (Object) null)) {
                                    return this.titleList.size() - 2;
                                }
                                return this.titleList.size();
                            }
                            size = this.titleList.size();
                        }
                    }
                }
                return this.titleList.size();
            }
            size = this.titleList.size();
        }
        return size - 1;
    }

    /* compiled from: DashboardAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/dashboard/DashboardAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/dashboard/DashboardAdapter;Landroid/view/View;)V", "card", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "iconView", "Landroid/widget/ImageView;", "titleView", "Landroid/widget/TextView;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final LinearLayout card;
        private final ImageView iconView;
        final /* synthetic */ DashboardAdapter this$0;
        private final TextView titleView;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(DashboardAdapter dashboardAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = dashboardAdapter;
            this.card = (LinearLayout) itemView.findViewById(R.id.card_dash);
            this.iconView = (ImageView) itemView.findViewById(R.id.iv_dash);
            this.titleView = (TextView) itemView.findViewById(R.id.tv_title_dash);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.titleList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "titleList[position]");
                Object obj2 = this.this$0.iconList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj2, "iconList[position]");
                this.iconView.setImageResource(((Number) obj2).intValue());
                this.titleView.setText((String) obj);
                LinearLayout linearLayout = this.card;
                final DashboardAdapter dashboardAdapter = this.this$0;
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DashboardAdapter.ViewHolder.onBind$lambda$0(DashboardAdapter.this, position, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(DashboardAdapter this$0, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.onDashItemClicked(i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<String> dashTitleList, ArrayList<Integer> iconTitleList) {
        Intrinsics.checkNotNullParameter(dashTitleList, "dashTitleList");
        Intrinsics.checkNotNullParameter(iconTitleList, "iconTitleList");
        this.titleList.clear();
        this.iconList.clear();
        this.titleList.addAll(dashTitleList);
        this.iconList.addAll(iconTitleList);
        notifyDataSetChanged();
    }

    public final void setCallBack(DashboardFragment context) {
        this.listener = context;
    }
}