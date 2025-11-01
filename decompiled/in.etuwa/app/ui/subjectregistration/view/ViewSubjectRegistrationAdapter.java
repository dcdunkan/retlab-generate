package in.etuwa.app.ui.subjectregistration.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.subjectregistration.Category;
import in.etuwa.app.data.model.subjectregistration.Subject;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewSubjectRegistrationAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0003J(\u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001cR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationAdapter$StatusListCallBack;", "subjectList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subjectregistration/Category;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "dpToPx", "", "dp", "getItemCount", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSubjectListCallBack", "Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationDialog;", "StatusListCallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewSubjectRegistrationAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private StatusListCallBack listener;
    private final ArrayList<Category> subjectList = new ArrayList<>();

    /* compiled from: ViewSubjectRegistrationAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationAdapter$StatusListCallBack;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface StatusListCallBack {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view_sub_reg, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …w_sub_reg, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.subjectList.size() > 0) {
            return this.subjectList.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.subjectList.isEmpty() ? 1 : 0;
    }

    /* compiled from: ViewSubjectRegistrationAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationAdapter;Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "subjectsContainer", "Landroid/widget/LinearLayout;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView name;
        private final LinearLayout subjectsContainer;
        final /* synthetic */ ViewSubjectRegistrationAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ViewSubjectRegistrationAdapter viewSubjectRegistrationAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = viewSubjectRegistrationAdapter;
            this.name = (TextView) itemView.findViewById(R.id.category_name_tv);
            this.subjectsContainer = (LinearLayout) itemView.findViewById(R.id.subjects_container);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            String obj;
            Spanned fromHtml;
            super.onBind(position);
            try {
                Object obj2 = this.this$0.subjectList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj2, "subjectList[position]");
                Category category = (Category) obj2;
                this.name.setText(category.getName());
                this.subjectsContainer.removeAllViews();
                Iterator<Subject> it = category.getSubjects().iterator();
                while (it.hasNext()) {
                    Subject next = it.next();
                    if (Build.VERSION.SDK_INT >= 24) {
                        String name = next.getName();
                        if (name == null) {
                            name = "";
                        }
                        fromHtml = Html.fromHtml(name, 0);
                        obj = fromHtml.toString();
                    } else {
                        String name2 = next.getName();
                        if (name2 == null) {
                            name2 = "";
                        }
                        obj = Html.fromHtml(name2).toString();
                    }
                    this.subjectsContainer.addView(onBind$createRow(this.this$0, "Preference " + (Integer.parseInt(next.getPreference()) + 1), obj));
                    LinearLayout onBind$createRow = onBind$createRow(this.this$0, "Status", next.getStatus());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(0, 0, 0, this.this$0.dpToPx(0));
                    onBind$createRow.setLayoutParams(layoutParams);
                    this.subjectsContainer.addView(onBind$createRow);
                    View view = new View(this.this$0.context);
                    ViewSubjectRegistrationAdapter viewSubjectRegistrationAdapter = this.this$0;
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, viewSubjectRegistrationAdapter.dpToPx(1));
                    layoutParams2.setMargins(viewSubjectRegistrationAdapter.dpToPx(15), viewSubjectRegistrationAdapter.dpToPx(5), viewSubjectRegistrationAdapter.dpToPx(15), viewSubjectRegistrationAdapter.dpToPx(10));
                    view.setLayoutParams(layoutParams2);
                    view.setBackgroundColor(Color.parseColor("#2077C9"));
                    this.subjectsContainer.addView(view);
                }
            } catch (Exception unused) {
                System.out.println((Object) "");
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static final LinearLayout onBind$createRow(ViewSubjectRegistrationAdapter viewSubjectRegistrationAdapter, String str, String str2) {
            int color;
            LinearLayout linearLayout = new LinearLayout(viewSubjectRegistrationAdapter.context);
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 4, 0, 4);
            linearLayout.setLayoutParams(layoutParams);
            Context context = viewSubjectRegistrationAdapter.context;
            Intrinsics.checkNotNull(context);
            Typeface font = ResourcesCompat.getFont(context, R.font.poppins_regular);
            TextView textView = new TextView(viewSubjectRegistrationAdapter.context);
            textView.setText(str);
            textView.setTextSize(14.0f);
            textView.setTypeface(font);
            Context context2 = textView.getContext();
            Intrinsics.checkNotNull(context2);
            textView.setTextColor(ContextCompat.getColor(context2, R.color.colorBlack));
            textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView textView2 = new TextView(viewSubjectRegistrationAdapter.context);
            textView2.setText(str2);
            textView2.setTextSize(14.0f);
            textView2.setTypeface(font);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (Intrinsics.areEqual(str, "Status")) {
                String upperCase = str2.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                switch (upperCase.hashCode()) {
                    case -75252643:
                        if (upperCase.equals("APPLIED")) {
                            color = Color.parseColor("#2196F3");
                            break;
                        }
                        Context context3 = textView2.getContext();
                        Intrinsics.checkNotNull(context3);
                        color = ContextCompat.getColor(context3, R.color.colorBlack);
                        break;
                    case 35394935:
                        if (upperCase.equals("PENDING")) {
                            color = Color.parseColor("#FFC107");
                            break;
                        }
                        Context context32 = textView2.getContext();
                        Intrinsics.checkNotNull(context32);
                        color = ContextCompat.getColor(context32, R.color.colorBlack);
                        break;
                    case 174130302:
                        if (upperCase.equals("REJECTED")) {
                            color = Color.parseColor("#F44336");
                            break;
                        }
                        Context context322 = textView2.getContext();
                        Intrinsics.checkNotNull(context322);
                        color = ContextCompat.getColor(context322, R.color.colorBlack);
                        break;
                    case 1947256515:
                        if (upperCase.equals("RE-APPLIED")) {
                            color = Color.parseColor("#008000");
                            break;
                        }
                        Context context3222 = textView2.getContext();
                        Intrinsics.checkNotNull(context3222);
                        color = ContextCompat.getColor(context3222, R.color.colorBlack);
                        break;
                    case 1967871671:
                        if (upperCase.equals("APPROVED")) {
                            color = Color.parseColor("#4CAF50");
                            break;
                        }
                        Context context32222 = textView2.getContext();
                        Intrinsics.checkNotNull(context32222);
                        color = ContextCompat.getColor(context32222, R.color.colorBlack);
                        break;
                    default:
                        Context context322222 = textView2.getContext();
                        Intrinsics.checkNotNull(context322222);
                        color = ContextCompat.getColor(context322222, R.color.colorBlack);
                        break;
                }
                textView2.setTextColor(color);
            } else {
                Context context4 = textView2.getContext();
                Intrinsics.checkNotNull(context4);
                textView2.setTextColor(ContextCompat.getColor(context4, R.color.colorBlack));
            }
            linearLayout.addView(textView);
            linearLayout.addView(textView2);
            return linearLayout;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Category> list, Context context) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(context, "context");
        this.subjectList.clear();
        this.subjectList.addAll(list);
        this.context = context;
        notifyDataSetChanged();
    }

    public final void setSubjectListCallBack(ViewSubjectRegistrationDialog context) {
        this.listener = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dpToPx(int dp) {
        Context context = this.context;
        Intrinsics.checkNotNull(context);
        return (int) TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }
}