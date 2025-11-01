package in.etuwa.app.ui.subject.syllabus;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.subject.syllabus.Syllabus;
import in.etuwa.app.data.model.subject.syllabus.Topic;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SyllabusAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J&\u0010\r\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/ui/subject/syllabus/SyllabusAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "context", "Landroid/content/Context;", "isCovered", "", "()Z", "syllabuses", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subject/syllabus/Syllabus;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SyllabusAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private final ArrayList<Syllabus> syllabuses = new ArrayList<>();
    private final boolean isCovered = true;

    /* renamed from: isCovered, reason: from getter */
    public final boolean getIsCovered() {
        return this.isCovered;
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_syllabus, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …_syllabus, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.syllabuses.size() > 0) {
            return this.syllabuses.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.syllabuses.isEmpty() ? 1 : 0;
    }

    /* compiled from: SyllabusAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/subject/syllabus/SyllabusAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/subject/syllabus/SyllabusAdapter;Landroid/view/View;)V", "module", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "topicView", "Landroid/widget/LinearLayout;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView module;
        final /* synthetic */ SyllabusAdapter this$0;
        private final LinearLayout topicView;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SyllabusAdapter syllabusAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = syllabusAdapter;
            this.module = (TextView) itemView.findViewById(R.id.module);
            this.topicView = (LinearLayout) itemView.findViewById(R.id.topic_view2);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            Spanned fromHtml;
            Resources resources;
            super.onBind(position);
            try {
                Object obj = this.this$0.syllabuses.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "syllabuses[position]");
                Syllabus syllabus = (Syllabus) obj;
                this.module.setText("Module : " + syllabus.getModule());
                if (Build.VERSION.SDK_INT >= 24) {
                    Html.fromHtml(syllabus.getTopics().get(0).getTopic(), 0);
                } else {
                    Html.fromHtml(syllabus.getTopics().get(0).getTopic());
                }
                ArrayList<Topic> topics = syllabus.getTopics();
                SyllabusAdapter syllabusAdapter = this.this$0;
                for (Topic topic : topics) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        fromHtml = Html.fromHtml(topic.getTopic(), 0);
                    } else {
                        fromHtml = Html.fromHtml(topic.getTopic());
                    }
                    LinearLayout linearLayout = new LinearLayout(syllabusAdapter.context);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(10, 10, 10, 10);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(syllabusAdapter.context);
                    textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    textView.setTextSize(16.0f);
                    textView.setText("• " + ((Object) fromHtml));
                    textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    linearLayout.addView(textView);
                    View view = new View(syllabusAdapter.context);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, 3));
                    Context context = syllabusAdapter.context;
                    if (context != null && (resources = context.getResources()) != null) {
                        view.setBackgroundColor(resources.getColor(R.color.view_color));
                    }
                    linearLayout.addView(view);
                    LinearLayout linearLayout2 = this.topicView;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(linearLayout);
                    }
                }
                System.out.println((Object) ("=======================" + syllabus.getTopics().size()));
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Syllabus> list, Context context) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(context, "context");
        this.syllabuses.clear();
        this.syllabuses.addAll(list);
        this.context = context;
        notifyDataSetChanged();
    }
}