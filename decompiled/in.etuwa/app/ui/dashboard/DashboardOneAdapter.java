package in.etuwa.app.ui.dashboard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.dashboard.DashboardOneAdapter;
import in.etuwa.app.utils.DashboardItems;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: DashboardOneAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DashboardOneAdapter extends RecyclerView.Adapter<BaseViewHolder> implements KoinComponent {
    private Context context;
    private final ArrayList<Integer> iconList;
    private CallBack listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private final ArrayList<String> titleList;

    /* JADX INFO: compiled from: DashboardOneAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/dashboard/DashboardOneAdapter$CallBack;", "", "onDashItemClickedNew", "", "title", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void onDashItemClickedNew(String title);
    }

    public DashboardOneAdapter() {
        final DashboardOneAdapter dashboardOneAdapter = this;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.dashboard.DashboardOneAdapter$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                Scope rootScope;
                KoinComponent koinComponent = dashboardOneAdapter;
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
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_new_dash, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context)\n   …_new_dash, parent, false)");
        return new ViewHolder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.titleList.size();
    }

    /* JADX INFO: compiled from: DashboardOneAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/dashboard/DashboardOneAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/dashboard/DashboardOneAdapter;Landroid/view/View;)V", "card", "Landroidx/cardview/widget/CardView;", "kotlin.jvm.PlatformType", "iconBg", "Landroid/widget/LinearLayout;", "iconView", "Landroid/widget/ImageView;", "titleView", "Landroid/widget/TextView;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final CardView card;
        private final LinearLayout iconBg;
        private final ImageView iconView;
        final /* synthetic */ DashboardOneAdapter this$0;
        private final TextView titleView;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(DashboardOneAdapter dashboardOneAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = dashboardOneAdapter;
            this.card = (CardView) itemView.findViewById(R.id.card_dash);
            this.iconBg = (LinearLayout) itemView.findViewById(R.id.icon_bg);
            this.iconView = (ImageView) itemView.findViewById(R.id.iv_dash);
            this.titleView = (TextView) itemView.findViewById(R.id.tv_title_dash);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.titleList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "titleList[position]");
                final String str = (String) obj;
                Object obj2 = this.this$0.iconList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj2, "iconList[position]");
                int iIntValue = ((Number) obj2).intValue();
                Context context = this.this$0.context;
                Intrinsics.checkNotNull(context);
                Integer num = DashboardItems.INSTANCE.getColorTint().get(position);
                Intrinsics.checkNotNullExpressionValue(num, "DashboardItems.colorTint[position]");
                int color = ContextCompat.getColor(context, num.intValue());
                Context context2 = this.this$0.context;
                Intrinsics.checkNotNull(context2);
                Integer num2 = DashboardItems.INSTANCE.getColorCircleTint().get(position);
                Intrinsics.checkNotNullExpressionValue(num2, "DashboardItems.colorCircleTint[position]");
                ContextCompat.getColor(context2, num2.intValue());
                Context context3 = this.this$0.context;
                Intrinsics.checkNotNull(context3);
                Integer num3 = DashboardItems.INSTANCE.getColorBg().get(position);
                Intrinsics.checkNotNullExpressionValue(num3, "DashboardItems.colorBg[position]");
                int color2 = ContextCompat.getColor(context3, num3.intValue());
                this.card.setCardBackgroundColor(color2);
                ImageViewCompat.setImageTintList(this.iconView, ColorStateList.valueOf(color));
                LinearLayout linearLayout = this.iconBg;
                Integer num4 = DashboardItems.INSTANCE.getDrawableIconBg().get(position);
                Intrinsics.checkNotNullExpressionValue(num4, "DashboardItems.drawableIconBg[position]");
                linearLayout.setBackgroundResource(num4.intValue());
                this.card.setCardBackgroundColor(color2);
                this.iconView.setImageResource(iIntValue);
                this.titleView.setText(str);
                CardView cardView = this.card;
                final DashboardOneAdapter dashboardOneAdapter = this.this$0;
                cardView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardOneAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DashboardOneAdapter.ViewHolder.onBind$lambda$0(dashboardOneAdapter, str, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(DashboardOneAdapter this$0, String title, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(title, "$title");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.onDashItemClickedNew(title);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<String> dashTitleList, ArrayList<Integer> iconTitleList, Context context) {
        Intrinsics.checkNotNullParameter(dashTitleList, "dashTitleList");
        Intrinsics.checkNotNullParameter(iconTitleList, "iconTitleList");
        Intrinsics.checkNotNullParameter(context, "context");
        this.titleList.clear();
        this.iconList.clear();
        this.titleList.addAll(dashTitleList);
        this.iconList.addAll(iconTitleList);
        this.context = context;
        notifyDataSetChanged();
    }

    public final void setCallBack(DashboardFragment context) {
        this.listener = context;
    }
}