package in.etuwa.app.ui.assignment;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import at.blogc.android.views.ExpandableTextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.assignment.Assignment;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.assignment.AssignmentAdapter;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: AssignmentAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/assignment/AssignmentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "assignments", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/assignment/Assignment;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/assignment/AssignmentAdapter$AssignmentListener;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAssignmentListener", "context", "Lin/etuwa/app/ui/assignment/AssignmentFragment;", "AssignmentListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AssignmentAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<Assignment> assignments = new ArrayList<>();
    private AssignmentListener listener;

    /* compiled from: AssignmentAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/assignment/AssignmentAdapter$AssignmentListener;", "", "checkFileExistence", "", "fileName", "", "flag", "deleteAssignment", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "onPickDoc", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AssignmentListener {
        boolean checkFileExistence(String fileName, boolean flag);

        void deleteAssignment(String id);

        void downloadFile(String url, int position, boolean flag);

        void onPickDoc(String id);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_assignment, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …ssignment, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.assignments.size() > 0) {
            return this.assignments.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.assignments.isEmpty() ? 1 : 0;
    }

    /* compiled from: AssignmentAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/ui/assignment/AssignmentAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/assignment/AssignmentAdapter;Landroid/view/View;)V", "assDetailsLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "assExpandLayout", "deleteBtn", "Landroid/widget/TextView;", "detailTV", ErrorBundle.DETAIL_ENTRY, "Lat/blogc/android/views/ExpandableTextView;", "detailsLayout", "downBtn", "issueDate", "lastDate", "sub", "submittedView", "title", "toggle", "upBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final LinearLayout assDetailsLayout;
        private final LinearLayout assExpandLayout;
        private final TextView deleteBtn;
        private final TextView detailTV;
        private final ExpandableTextView details;
        private final LinearLayout detailsLayout;
        private final TextView downBtn;
        private final TextView issueDate;
        private final TextView lastDate;
        private final TextView sub;
        private final View submittedView;
        final /* synthetic */ AssignmentAdapter this$0;
        private final TextView title;
        private final TextView toggle;
        private final TextView upBtn;

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$4(View view) {
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(AssignmentAdapter assignmentAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = assignmentAdapter;
            this.sub = (TextView) itemView.findViewById(R.id.assi_name);
            this.title = (TextView) itemView.findViewById(R.id.assi_title);
            this.issueDate = (TextView) itemView.findViewById(R.id.assi_issue_date);
            this.lastDate = (TextView) itemView.findViewById(R.id.assi_last_date);
            this.downBtn = (TextView) itemView.findViewById(R.id.assi_download);
            this.upBtn = (TextView) itemView.findViewById(R.id.assi_upload);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.delete_assignment);
            this.detailsLayout = (LinearLayout) itemView.findViewById(R.id.assi_detail_layout);
            this.details = (ExpandableTextView) itemView.findViewById(R.id.assi_details);
            this.toggle = (TextView) itemView.findViewById(R.id.assi_toggle);
            this.assDetailsLayout = (LinearLayout) itemView.findViewById(R.id.ass_details_layout);
            this.assExpandLayout = (LinearLayout) itemView.findViewById(R.id.expand_ass_layout);
            this.submittedView = itemView.findViewById(R.id.submitted_view);
            this.detailTV = (TextView) itemView.findViewById(R.id.details);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.assignments.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "assignments[position]");
                final Assignment assignment = (Assignment) obj;
                this.sub.setText(StringsKt.trim((CharSequence) StringsKt.split$default((CharSequence) assignment.getSubject(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null).get(1)).toString());
                this.title.setText(assignment.getTitle());
                this.issueDate.setText(assignment.getIssueDate());
                this.lastDate.setText(assignment.getLastDate());
                this.details.setText(assignment.getDetails());
                if (Intrinsics.areEqual(assignment.getDetails(), "")) {
                    this.detailTV.setVisibility(8);
                } else {
                    this.detailTV.setVisibility(0);
                }
                this.detailsLayout.setVisibility(assignment.getDetails().length() == 0 ? 8 : 0);
                this.details.setAnimationDuration(1500L);
                this.details.setInterpolator(new OvershootInterpolator());
                this.toggle.setBackgroundResource(R.drawable.ic_expand);
                this.details.setExpandInterpolator(new OvershootInterpolator());
                this.details.setCollapseInterpolator(new OvershootInterpolator());
                this.toggle.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AssignmentAdapter.ViewHolder.onBind$lambda$0(AssignmentAdapter.ViewHolder.this, view);
                    }
                });
                if (Intrinsics.areEqual(assignment.getStatus(), "SUBMITTED")) {
                    this.submittedView.setBackgroundColor(Color.rgb(120, 217, 3));
                } else {
                    this.submittedView.setBackgroundColor(Color.rgb(225, 51, 0));
                }
                if (Intrinsics.areEqual(assignment.getStatus(), "SUBMITTED") && assignment.getCanSubmit()) {
                    this.deleteBtn.setVisibility(0);
                } else {
                    this.deleteBtn.setVisibility(8);
                }
                TextView textView = this.deleteBtn;
                final AssignmentAdapter assignmentAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AssignmentAdapter.ViewHolder.onBind$lambda$1(AssignmentAdapter.this, assignment, view);
                    }
                });
                Regex regex = new Regex("[^A-Za-z0-9.]");
                String replace = regex.replace(StringsKt.substringAfterLast$default(assignment.getUrl(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                String replace2 = regex.replace(StringsKt.substringAfterLast$default(assignment.getUploadedFile(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                if (assignment.getUrl().length() == 0) {
                    this.downBtn.setVisibility(4);
                } else {
                    this.downBtn.setVisibility(0);
                    AssignmentListener assignmentListener = this.this$0.listener;
                    Boolean valueOf = assignmentListener != null ? Boolean.valueOf(assignmentListener.checkFileExistence(replace, true)) : null;
                    Intrinsics.checkNotNull(valueOf);
                    if (valueOf.booleanValue()) {
                        this.downBtn.setText("Open");
                        this.downBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_inactive);
                    } else {
                        this.downBtn.setText("Download");
                        this.downBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_dark);
                    }
                }
                TextView textView2 = this.downBtn;
                final AssignmentAdapter assignmentAdapter2 = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AssignmentAdapter.ViewHolder.onBind$lambda$2(Assignment.this, assignmentAdapter2, position, this, view);
                    }
                });
                if (assignment.getUpload()) {
                    this.upBtn.setVisibility(0);
                    if (Intrinsics.areEqual(assignment.getStatus(), "SUBMITTED")) {
                        if (!Intrinsics.areEqual(assignment.getUploadedFile(), "")) {
                            AssignmentListener assignmentListener2 = this.this$0.listener;
                            Boolean valueOf2 = assignmentListener2 != null ? Boolean.valueOf(assignmentListener2.checkFileExistence(replace2, false)) : null;
                            Intrinsics.checkNotNull(valueOf2);
                            if (valueOf2.booleanValue()) {
                                this.upBtn.setText("Open Submitted File");
                                this.upBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_inactive);
                            } else {
                                this.upBtn.setText("View Submitted File");
                                this.upBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_dark);
                            }
                        } else {
                            this.upBtn.setVisibility(4);
                        }
                    } else {
                        this.upBtn.setText("Upload");
                        this.upBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_dark);
                    }
                }
                TextView textView3 = this.upBtn;
                final AssignmentAdapter assignmentAdapter3 = this.this$0;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentAdapter$ViewHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AssignmentAdapter.ViewHolder.onBind$lambda$3(Assignment.this, assignmentAdapter3, this, position, view);
                    }
                });
                this.assExpandLayout.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentAdapter$ViewHolder$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AssignmentAdapter.ViewHolder.onBind$lambda$4(view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.details.toggle();
            if (this$0.details.isExpanded()) {
                this$0.details.collapse();
                this$0.toggle.setBackgroundResource(R.drawable.ic_expand);
            } else {
                this$0.details.expand();
                this$0.toggle.setBackgroundResource(R.drawable.ic_collapse);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(AssignmentAdapter this$0, Assignment assignment, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(assignment, "$assignment");
            AssignmentListener assignmentListener = this$0.listener;
            if (assignmentListener != null) {
                assignmentListener.deleteAssignment(assignment.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(Assignment assignment, AssignmentAdapter this$0, int i, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(assignment, "$assignment");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (assignment.getCanDownload()) {
                AssignmentListener assignmentListener = this$0.listener;
                if (assignmentListener != null) {
                    assignmentListener.downloadFile(assignment.getUrl(), i, true);
                    return;
                }
                return;
            }
            TextView downBtn = this$1.downBtn;
            Intrinsics.checkNotNullExpressionValue(downBtn, "downBtn");
            ToastExtKt.showInfoToast(downBtn, "Question can download only after Start time");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$3(Assignment assignment, AssignmentAdapter this$0, ViewHolder this$1, int i, View view) {
            Intrinsics.checkNotNullParameter(assignment, "$assignment");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!Intrinsics.areEqual(assignment.getStatus(), "NOT SUBMITTED")) {
                AssignmentListener assignmentListener = this$0.listener;
                if (assignmentListener != null) {
                    assignmentListener.downloadFile(assignment.getUploadedFile(), i, false);
                    return;
                }
                return;
            }
            if (assignment.getCanSubmit()) {
                AssignmentListener assignmentListener2 = this$0.listener;
                if (assignmentListener2 != null) {
                    assignmentListener2.onPickDoc(assignment.getId());
                    return;
                }
                return;
            }
            TextView upBtn = this$1.upBtn;
            Intrinsics.checkNotNullExpressionValue(upBtn, "upBtn");
            ToastExtKt.showInfoToast(upBtn, "Student can submit assignment from issued time to the end time.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setIsRecyclable(false);
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Assignment> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.assignments.clear();
        this.assignments.addAll(list);
        notifyDataSetChanged();
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setAssignmentListener(AssignmentFragment context) {
        this.listener = context;
    }
}