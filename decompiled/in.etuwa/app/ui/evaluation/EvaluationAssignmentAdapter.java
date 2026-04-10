package in.etuwa.app.ui.evaluation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import at.blogc.android.views.ExpandableTextView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.config.CookieSpecs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.assignment.Assignment;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.i18n.ErrorBundle;

/* JADX INFO: compiled from: EvaluationAssignmentAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EvaluationAssignmentAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<Assignment> assignments = new ArrayList<>();
    private final ArrayList<Assignment> filteredAssignments = new ArrayList<>();
    private Boolean flag;
    private AssignmentListener listener;

    /* JADX INFO: compiled from: EvaluationAssignmentAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/evaluation/EvaluationAssignmentAdapter$AssignmentListener;", "", "checkFileExistence", "", "fileName", "", "flag", "deleteAssignment", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "onPickDoc", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_evaluation_assignments, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …signments, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…mpty_view, parent, false)");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.filteredAssignments.size() > 0) {
            return this.filteredAssignments.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.filteredAssignments.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: EvaluationAssignmentAdapter.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lin/etuwa/app/ui/evaluation/EvaluationAssignmentAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/evaluation/EvaluationAssignmentAdapter;Landroid/view/View;)V", "assDetailsLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "deleteBtn", "Landroid/widget/TextView;", "deleteCv", "Lcom/google/android/material/card/MaterialCardView;", "detailTV", ErrorBundle.DETAIL_ENTRY, "Lat/blogc/android/views/ExpandableTextView;", "detailsLayout", "downBtn", "downloadCv", "isExpanded", "", "issueDate", "lastDate", "linkTV", "sub", "submittedView", "title", "toggle", "upBtn", "uploadCv", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final LinearLayout assDetailsLayout;
        private final TextView deleteBtn;
        private final MaterialCardView deleteCv;
        private final TextView detailTV;
        private final ExpandableTextView details;
        private final LinearLayout detailsLayout;
        private final TextView downBtn;
        private final MaterialCardView downloadCv;
        private boolean isExpanded;
        private final TextView issueDate;
        private final TextView lastDate;
        private final TextView linkTV;
        private final TextView sub;
        private final View submittedView;
        final /* synthetic */ EvaluationAssignmentAdapter this$0;
        private final TextView title;
        private final TextView toggle;
        private final TextView upBtn;
        private final MaterialCardView uploadCv;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(EvaluationAssignmentAdapter evaluationAssignmentAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = evaluationAssignmentAdapter;
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
            this.submittedView = itemView.findViewById(R.id.submitted_view);
            this.detailTV = (TextView) itemView.findViewById(R.id.details);
            this.linkTV = (TextView) itemView.findViewById(R.id.linkTv);
            this.uploadCv = (MaterialCardView) itemView.findViewById(R.id.uploadCv);
            this.downloadCv = (MaterialCardView) itemView.findViewById(R.id.downloadCv);
            this.deleteCv = (MaterialCardView) itemView.findViewById(R.id.deleteCv);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00ef A[Catch: Exception -> 0x0329, TryCatch #0 {Exception -> 0x0329, blocks: (B:3:0x000f, B:5:0x004a, B:7:0x0056, B:9:0x005e, B:11:0x00b8, B:16:0x00cc, B:18:0x00f5, B:23:0x011b, B:28:0x012f, B:34:0x013b, B:43:0x0165, B:45:0x01c3, B:47:0x01da, B:49:0x01e4, B:51:0x01ea, B:53:0x01ff, B:56:0x021e, B:59:0x0225, B:61:0x0231, B:64:0x0238, B:66:0x0246, B:72:0x0252, B:84:0x0287, B:86:0x0299, B:88:0x02ad, B:93:0x02c1, B:95:0x02c9, B:100:0x02d3, B:102:0x02e6, B:106:0x031c, B:101:0x02dd, B:103:0x02f2, B:104:0x02fd, B:105:0x0312, B:73:0x025d, B:75:0x0271, B:81:0x027e, B:83:0x0284, B:52:0x01f5, B:46:0x01cf, B:35:0x0146, B:42:0x0162, B:17:0x00ef, B:8:0x0059), top: B:111:0x000f }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0138  */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v3, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // in.etuwa.app.ui.base.BaseViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onBind(final int r18) {
            /*
                Method dump skipped, instruction units count: 814
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.evaluation.EvaluationAssignmentAdapter.ViewHolder.onBind(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(Assignment assignment, Context context, View view) {
            Intrinsics.checkNotNullParameter(assignment, "$assignment");
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(assignment.getLink())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.details.toggle();
            this$0.toggle.setBackgroundResource(this$0.details.isExpanded() ? R.drawable.ic_collapse : R.drawable.ic_expand);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            boolean z = !this$0.isExpanded;
            this$0.isExpanded = z;
            this$0.assDetailsLayout.setVisibility(z ? 0 : 8);
            this$0.detailTV.setRotation(this$0.isExpanded ? 270.0f : 90.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$3(EvaluationAssignmentAdapter this$0, Assignment assignment, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(assignment, "$assignment");
            AssignmentListener assignmentListener = this$0.listener;
            if (assignmentListener != null) {
                assignmentListener.deleteAssignment(assignment.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$4(Assignment assignment, EvaluationAssignmentAdapter this$0, int i, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(assignment, "$assignment");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (assignment.getCanDownload()) {
                AssignmentListener assignmentListener = this$0.listener;
                if (assignmentListener != null) {
                    String url = assignment.getUrl();
                    if (url == null) {
                        url = "";
                    }
                    assignmentListener.downloadFile(url, i, true);
                    return;
                }
                return;
            }
            TextView downBtn = this$1.downBtn;
            Intrinsics.checkNotNullExpressionValue(downBtn, "downBtn");
            ToastExtKt.showInfoToast(downBtn, "Question can download only after Start time");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$5(Assignment assignment, EvaluationAssignmentAdapter this$0, ViewHolder this$1, int i, View view) {
            Intrinsics.checkNotNullParameter(assignment, "$assignment");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!Intrinsics.areEqual(assignment.getStatus(), "NOT SUBMITTED")) {
                AssignmentListener assignmentListener = this$0.listener;
                if (assignmentListener != null) {
                    String uploadedFile = assignment.getUploadedFile();
                    if (uploadedFile == null) {
                        uploadedFile = "";
                    }
                    assignmentListener.downloadFile(uploadedFile, i, false);
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
        ArrayList<Assignment> arrayList = list;
        this.assignments.addAll(arrayList);
        this.filteredAssignments.clear();
        this.filteredAssignments.addAll(arrayList);
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void filter(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.util.ArrayList<in.etuwa.app.data.model.assignment.Assignment> r0 = r12.filteredAssignments
            r0.clear()
            r0 = r13
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L1e
            java.util.ArrayList<in.etuwa.app.data.model.assignment.Assignment> r13 = r12.filteredAssignments
            java.util.ArrayList<in.etuwa.app.data.model.assignment.Assignment> r0 = r12.assignments
            java.util.Collection r0 = (java.util.Collection) r0
            r13.addAll(r0)
            goto L9a
        L1e:
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r13 = r13.toLowerCase(r0)
            java.lang.String r0 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r0)
            java.util.ArrayList<in.etuwa.app.data.model.assignment.Assignment> r1 = r12.filteredAssignments
            java.util.ArrayList<in.etuwa.app.data.model.assignment.Assignment> r2 = r12.assignments
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L3a:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L93
            java.lang.Object r4 = r2.next()
            r5 = r4
            in.etuwa.app.data.model.assignment.Assignment r5 = (in.etuwa.app.data.model.assignment.Assignment) r5
            java.lang.String r6 = r5.getSubject()
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r6 = r6.toLowerCase(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = r13
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r8 = 0
            r9 = 2
            r10 = 0
            boolean r6 = kotlin.text.StringsKt.contains$default(r6, r7, r8, r9, r10)
            if (r6 != 0) goto L8c
            java.lang.String r6 = r5.getTitle()
            java.util.Locale r11 = java.util.Locale.ROOT
            java.lang.String r6 = r6.toLowerCase(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.contains$default(r6, r7, r8, r9, r10)
            if (r6 != 0) goto L8c
            java.lang.String r5 = r5.getDetails()
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = kotlin.text.StringsKt.contains$default(r5, r7, r8, r9, r10)
            if (r5 == 0) goto L8d
        L8c:
            r8 = 1
        L8d:
            if (r8 == 0) goto L3a
            r3.add(r4)
            goto L3a
        L93:
            java.util.List r3 = (java.util.List) r3
            java.util.Collection r3 = (java.util.Collection) r3
            r1.addAll(r3)
        L9a:
            r12.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.evaluation.EvaluationAssignmentAdapter.filter(java.lang.String):void");
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setAssignmentListener(EvaluationFragment context) {
        this.listener = context;
    }

    public static /* synthetic */ String orShort$default(EvaluationAssignmentAdapter evaluationAssignmentAdapter, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
        }
        return evaluationAssignmentAdapter.orShort(str, str2);
    }

    public final String orShort(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "default");
        String str3 = str;
        return ((str3 == null || StringsKt.isBlank(str3)) || Intrinsics.areEqual(str, "null")) ? str2 : str;
    }
}