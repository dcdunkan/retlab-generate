package in.etuwa.app.ui.profile.projectwork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.profileasiet.projectwork.ProjectWork;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.profile.projectwork.ProjectWorkAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: ProjectWorkAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/ui/profile/projectwork/ProjectWorkAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/projectwork/ProjectWorkAdapter$ProjectListener;", "moocCourse", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/profileasiet/projectwork/ProjectWork;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setProjectListener", "context", "Lin/etuwa/app/ui/profile/projectwork/ProjectWorkFragment;", "ProjectListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProjectWorkAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private ProjectListener listener;
    private final ArrayList<ProjectWork> moocCourse = new ArrayList<>();

    /* compiled from: ProjectWorkAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lin/etuwa/app/ui/profile/projectwork/ProjectWorkAdapter$ProjectListener;", "", "checkFileExistence", "", "fileName", "", "deleteBtnClicked", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "editBtnClicked", ErrorBundle.DETAIL_ENTRY, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ProjectListener {
        boolean checkFileExistence(String fileName);

        void deleteBtnClicked(String id);

        void downloadFile(String url, String position);

        void editBtnClicked(String id, String details);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_project_work, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …ject_work, parent, false)");
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

    /* compiled from: ProjectWorkAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/profile/projectwork/ProjectWorkAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/profile/projectwork/ProjectWorkAdapter;Landroid/view/View;)V", "deleteBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "detailsTv", "editBtn", "title", "viewBtn", "yearTv", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView deleteBtn;
        private final TextView detailsTv;
        private final TextView editBtn;
        final /* synthetic */ ProjectWorkAdapter this$0;
        private final TextView title;
        private final TextView viewBtn;
        private final TextView yearTv;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ProjectWorkAdapter projectWorkAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = projectWorkAdapter;
            this.title = (TextView) itemView.findViewById(R.id.title_tv);
            this.yearTv = (TextView) itemView.findViewById(R.id.year_tv);
            this.detailsTv = (TextView) itemView.findViewById(R.id.details_tv);
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
                final ProjectWork projectWork = (ProjectWork) obj;
                this.title.setText(projectWork.getType());
                this.yearTv.setText(projectWork.getYear());
                this.detailsTv.setText(projectWork.getDetails());
                if (Intrinsics.areEqual(projectWork.getFile(), "")) {
                    this.viewBtn.setVisibility(4);
                } else {
                    this.viewBtn.setVisibility(0);
                }
                TextView textView = this.viewBtn;
                if (textView != null) {
                    final ProjectWorkAdapter projectWorkAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.projectwork.ProjectWorkAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ProjectWorkAdapter.ViewHolder.onBind$lambda$0(ProjectWorkAdapter.this, projectWork, view);
                        }
                    });
                }
                TextView textView2 = this.editBtn;
                if (textView2 != null) {
                    final ProjectWorkAdapter projectWorkAdapter2 = this.this$0;
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.projectwork.ProjectWorkAdapter$ViewHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ProjectWorkAdapter.ViewHolder.onBind$lambda$1(ProjectWorkAdapter.this, projectWork, view);
                        }
                    });
                }
                TextView textView3 = this.deleteBtn;
                if (textView3 != null) {
                    final ProjectWorkAdapter projectWorkAdapter3 = this.this$0;
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.projectwork.ProjectWorkAdapter$ViewHolder$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ProjectWorkAdapter.ViewHolder.onBind$lambda$2(ProjectWorkAdapter.this, projectWork, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ProjectWorkAdapter this$0, ProjectWork moocCourse, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(moocCourse, "$moocCourse");
            ProjectListener projectListener = this$0.listener;
            if (projectListener != null) {
                projectListener.downloadFile(moocCourse.getFile(), moocCourse.getFile());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(ProjectWorkAdapter this$0, ProjectWork moocCourse, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(moocCourse, "$moocCourse");
            ProjectListener projectListener = this$0.listener;
            if (projectListener != null) {
                projectListener.editBtnClicked(moocCourse.getId(), moocCourse.getDetails());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(ProjectWorkAdapter this$0, ProjectWork moocCourse, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(moocCourse, "$moocCourse");
            ProjectListener projectListener = this$0.listener;
            if (projectListener != null) {
                projectListener.deleteBtnClicked(moocCourse.getId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<ProjectWork> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.moocCourse.clear();
        this.moocCourse.addAll(list);
        notifyDataSetChanged();
    }

    public final void setProjectListener(ProjectWorkFragment context) {
        this.listener = context;
    }
}