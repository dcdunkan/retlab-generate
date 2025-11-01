package in.etuwa.app.ui.profile.mooccourse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.profileasiet.mooccourse.MoocCourse;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.profile.mooccourse.MoocCourseAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MoocCourseAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/ui/profile/mooccourse/MoocCourseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/mooccourse/MoocCourseAdapter$MoocListener;", "moocCourse", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/profileasiet/mooccourse/MoocCourse;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMoocListener", "context", "Lin/etuwa/app/ui/profile/mooccourse/MoocCourseFragment;", "MoocListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MoocCourseAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private MoocListener listener;
    private final ArrayList<MoocCourse> moocCourse = new ArrayList<>();

    /* compiled from: MoocCourseAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J@\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/profile/mooccourse/MoocCourseAdapter$MoocListener;", "", "checkFileExistence", "", "fileName", "", "deleteBtnClicked", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "editBtnClicked", "title", "organised", "fromDate", "toDate", TypedValues.TransitionType.S_DURATION, "achievements", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface MoocListener {
        boolean checkFileExistence(String fileName);

        void deleteBtnClicked(String id);

        void downloadFile(String url, String position);

        void editBtnClicked(String id, String title, String organised, String fromDate, String toDate, String duration, String achievements);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mooc_course, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …oc_course, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.moocCourse.size() > 0) {
            return this.moocCourse.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.moocCourse.isEmpty() ? 1 : 0;
    }

    /* compiled from: MoocCourseAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/ui/profile/mooccourse/MoocCourseAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/profile/mooccourse/MoocCourseAdapter;Landroid/view/View;)V", "achievements", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "deleteBtn", "durationTv", "editBtn", "fromDate", "organisedBy", "title", "toDate", "viewBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView achievements;
        private final TextView deleteBtn;
        private final TextView durationTv;
        private final TextView editBtn;
        private final TextView fromDate;
        private final TextView organisedBy;
        final /* synthetic */ MoocCourseAdapter this$0;
        private final TextView title;
        private final TextView toDate;
        private final TextView viewBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(MoocCourseAdapter moocCourseAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = moocCourseAdapter;
            this.title = (TextView) itemView.findViewById(R.id.title_tv);
            this.organisedBy = (TextView) itemView.findViewById(R.id.organised_by);
            this.fromDate = (TextView) itemView.findViewById(R.id.from_date);
            this.toDate = (TextView) itemView.findViewById(R.id.to_date_tv);
            this.durationTv = (TextView) itemView.findViewById(R.id.duration_tv);
            this.achievements = (TextView) itemView.findViewById(R.id.achievements_tv);
            this.viewBtn = (TextView) itemView.findViewById(R.id.view_btn_hr);
            this.editBtn = (TextView) itemView.findViewById(R.id.edit_btn);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.delete_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.moocCourse.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "moocCourse[position]");
                final MoocCourse moocCourse = (MoocCourse) obj;
                this.title.setText(moocCourse.getName());
                this.organisedBy.setText(moocCourse.getPlatform());
                this.fromDate.setText(moocCourse.getFrom_date());
                this.toDate.setText(moocCourse.getTo_date());
                this.durationTv.setText(moocCourse.getDuration());
                this.achievements.setText(moocCourse.getAchievements());
                if (Intrinsics.areEqual(moocCourse.getFile(), "")) {
                    this.viewBtn.setVisibility(4);
                } else {
                    this.viewBtn.setVisibility(0);
                }
                TextView textView = this.viewBtn;
                if (textView != null) {
                    final MoocCourseAdapter moocCourseAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.mooccourse.MoocCourseAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MoocCourseAdapter.ViewHolder.onBind$lambda$0(MoocCourseAdapter.this, moocCourse, view);
                        }
                    });
                }
                TextView textView2 = this.editBtn;
                if (textView2 != null) {
                    final MoocCourseAdapter moocCourseAdapter2 = this.this$0;
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.mooccourse.MoocCourseAdapter$ViewHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MoocCourseAdapter.ViewHolder.onBind$lambda$1(MoocCourseAdapter.this, moocCourse, view);
                        }
                    });
                }
                TextView textView3 = this.deleteBtn;
                if (textView3 != null) {
                    final MoocCourseAdapter moocCourseAdapter3 = this.this$0;
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.mooccourse.MoocCourseAdapter$ViewHolder$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MoocCourseAdapter.ViewHolder.onBind$lambda$2(MoocCourseAdapter.this, moocCourse, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(MoocCourseAdapter this$0, MoocCourse moocCourse, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(moocCourse, "$moocCourse");
            MoocListener moocListener = this$0.listener;
            if (moocListener != null) {
                moocListener.downloadFile(moocCourse.getFile(), moocCourse.getFile());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(MoocCourseAdapter this$0, MoocCourse moocCourse, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(moocCourse, "$moocCourse");
            MoocListener moocListener = this$0.listener;
            if (moocListener != null) {
                moocListener.editBtnClicked(moocCourse.getId(), moocCourse.getName(), moocCourse.getPlatform(), moocCourse.getFrom_date(), moocCourse.getTo_date(), moocCourse.getDuration(), moocCourse.getAchievements());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(MoocCourseAdapter this$0, MoocCourse moocCourse, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(moocCourse, "$moocCourse");
            MoocListener moocListener = this$0.listener;
            if (moocListener != null) {
                moocListener.deleteBtnClicked(moocCourse.getId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<MoocCourse> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.moocCourse.clear();
        this.moocCourse.addAll(list);
        notifyDataSetChanged();
    }

    public final void setMoocListener(MoocCourseFragment context) {
        this.listener = context;
    }
}