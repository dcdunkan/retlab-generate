package in.etuwa.app.ui.subject.coverage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.subject.coverage.SubCovTopic;
import in.etuwa.app.data.model.subject.coverage.SubCoverage;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectCoverageAdapter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\n\u001a\u00020\u000b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lin/etuwa/app/ui/subject/coverage/SubjectCoverageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "context", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subject/coverage/SubCoverage;", "Lkotlin/collections/ArrayList;", "addItems", "", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubjectCoverageAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private final ArrayList<SubCoverage> list = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_subject_coverage, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …_coverage, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.list.size() > 0) {
            return this.list.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.list.isEmpty() ? 1 : 0;
    }

    /* compiled from: SubjectCoverageAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/subject/coverage/SubjectCoverageAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/subject/coverage/SubjectCoverageAdapter;Landroid/view/View;)V", "moduleName", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "topicView", "Landroid/widget/LinearLayout;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView moduleName;
        final /* synthetic */ SubjectCoverageAdapter this$0;
        private final LinearLayout topicView;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SubjectCoverageAdapter subjectCoverageAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = subjectCoverageAdapter;
            this.moduleName = (TextView) itemView.findViewById(R.id.tv_module_name);
            this.topicView = (LinearLayout) itemView.findViewById(R.id.topic_view);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            Resources resources;
            Resources resources2;
            Resources resources3;
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                SubCoverage subCoverage = (SubCoverage) obj;
                this.moduleName.setText("Module " + subCoverage.getModule() + " (" + subCoverage.getRatio() + "% Completed)");
                ArrayList<SubCovTopic> topic = subCoverage.getTopic();
                SubjectCoverageAdapter subjectCoverageAdapter = this.this$0;
                for (SubCovTopic subCovTopic : topic) {
                    LinearLayout linearLayout = new LinearLayout(subjectCoverageAdapter.context);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(10, 10, 10, 10);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(subjectCoverageAdapter.context);
                    textView.setLayoutParams(new LinearLayout.LayoutParams(-1, 10));
                    textView.setTextSize(16.0f);
                    textView.setTextColor(-1);
                    textView.getCompoundPaddingLeft();
                    linearLayout.addView(textView);
                    TextView textView2 = new TextView(subjectCoverageAdapter.context);
                    textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    textView2.setTextSize(16.0f);
                    if (subCovTopic.isCovered()) {
                        textView2.setText(subCovTopic.getTopicName());
                        textView.setBackgroundColor(Color.rgb(34, 139, 34));
                        Context context = subjectCoverageAdapter.context;
                        if (context != null && (resources3 = context.getResources()) != null) {
                            textView2.setTextColor(resources3.getColor(R.color.ms_black));
                        }
                    } else {
                        textView2.setText(subCovTopic.getTopicName());
                        textView.setBackgroundColor(Color.rgb(225, 51, 0));
                        Context context2 = subjectCoverageAdapter.context;
                        if (context2 != null && (resources = context2.getResources()) != null) {
                            textView2.setTextColor(resources.getColor(R.color.ms_black));
                        }
                    }
                    linearLayout.addView(textView2);
                    View view = new View(subjectCoverageAdapter.context);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, 3));
                    Context context3 = subjectCoverageAdapter.context;
                    if (context3 != null && (resources2 = context3.getResources()) != null) {
                        view.setBackgroundColor(resources2.getColor(R.color.view_color));
                    }
                    linearLayout.addView(view);
                    LinearLayout linearLayout2 = this.topicView;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(linearLayout);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<SubCoverage> list, Context context) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(context, "context");
        this.list.clear();
        this.list.addAll(list);
        this.context = context;
        notifyDataSetChanged();
    }
}