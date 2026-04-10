package in.etuwa.app.ui.subjectregistration.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.subjectregistration.Category;
import in.etuwa.app.data.model.subjectregistration.Subject;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewSubjectRegistrationAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ViewSubjectRegistrationAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private StatusListCallBack listener;
    private final ArrayList<Category> subjectList = new ArrayList<>();

    /* JADX INFO: compiled from: ViewSubjectRegistrationAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/view/ViewSubjectRegistrationAdapter$StatusListCallBack;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface StatusListCallBack {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view_sub_reg, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …w_sub_reg, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
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

    /* JADX INFO: compiled from: ViewSubjectRegistrationAdapter.kt */
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
            String string;
            super.onBind(position);
            try {
                Object obj = this.this$0.subjectList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "subjectList[position]");
                Category category = (Category) obj;
                this.name.setText(category.getName());
                this.subjectsContainer.removeAllViews();
                for (Subject subject : category.getSubjects()) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        String name = subject.getName();
                        if (name == null) {
                            name = "";
                        }
                        string = Html.fromHtml(name, 0).toString();
                    } else {
                        String name2 = subject.getName();
                        if (name2 == null) {
                            name2 = "";
                        }
                        string = Html.fromHtml(name2).toString();
                    }
                    this.subjectsContainer.addView(onBind$createRow(this.this$0, "Preference " + (Integer.parseInt(subject.getPreference()) + 1), string));
                    LinearLayout linearLayoutOnBind$createRow = onBind$createRow(this.this$0, "Status", subject.getStatus());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(0, 0, 0, this.this$0.dpToPx(0));
                    linearLayoutOnBind$createRow.setLayoutParams(layoutParams);
                    this.subjectsContainer.addView(linearLayoutOnBind$createRow);
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
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00e7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static final android.widget.LinearLayout onBind$createRow(in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationAdapter r8, java.lang.String r9, java.lang.String r10) {
            /*
                Method dump skipped, instruction units count: 298
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationAdapter.ViewHolder.onBind$createRow(in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationAdapter, java.lang.String, java.lang.String):android.widget.LinearLayout");
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