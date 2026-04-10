package in.etuwa.app.ui.evaluation;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.config.CookieSpecs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.tutorial.Tutorial;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EvaluationTutorialAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EvaluationTutorialAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private TutorialListener listener;
    private final ArrayList<Tutorial> tutorials = new ArrayList<>();
    private final ArrayList<Tutorial> filteredTutorials = new ArrayList<>();

    /* JADX INFO: compiled from: EvaluationTutorialAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/evaluation/EvaluationTutorialAdapter$TutorialListener;", "", "checkFileExistence", "", "fileName", "", "flag", "deleteTutorials", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "onPickDoc", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface TutorialListener {
        boolean checkFileExistence(String fileName, boolean flag);

        void deleteTutorials(String id);

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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tutorial, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context).inf…_tutorial, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…mpty_view, parent, false)");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.filteredTutorials.size() > 0) {
            return this.filteredTutorials.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.filteredTutorials.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: EvaluationTutorialAdapter.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0007*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lin/etuwa/app/ui/evaluation/EvaluationTutorialAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/evaluation/EvaluationTutorialAdapter;Landroid/view/View;)V", "deleteBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "deleteCv", "Lcom/google/android/material/card/MaterialCardView;", "detailTV", "detailsText", "downBtn", "downloadCv", "isExpanded", "", "issueDate", "lastDate", AttendanceDayDialogKt.ARG_SEM, NotificationCompat.CATEGORY_STATUS, "sub", "submittedView", "title", "tutDetailsLayout", "Landroid/widget/LinearLayout;", "upBtn", "uploadCv", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView deleteBtn;
        private final MaterialCardView deleteCv;
        private final TextView detailTV;
        private final TextView detailsText;
        private final TextView downBtn;
        private final MaterialCardView downloadCv;
        private boolean isExpanded;
        private final TextView issueDate;
        private final TextView lastDate;
        private final TextView semester;
        private final TextView status;
        private final TextView sub;
        private final View submittedView;
        final /* synthetic */ EvaluationTutorialAdapter this$0;
        private final TextView title;
        private final LinearLayout tutDetailsLayout;
        private final TextView upBtn;
        private final MaterialCardView uploadCv;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(EvaluationTutorialAdapter evaluationTutorialAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = evaluationTutorialAdapter;
            this.sub = (TextView) itemView.findViewById(R.id.tutorial_name);
            this.title = (TextView) itemView.findViewById(R.id.tutorial_title);
            this.semester = (TextView) itemView.findViewById(R.id.tutorial_sem);
            this.issueDate = (TextView) itemView.findViewById(R.id.tutorial_issue_date);
            this.lastDate = (TextView) itemView.findViewById(R.id.tutorial_last_date);
            this.status = (TextView) itemView.findViewById(R.id.tutorial_status);
            this.downBtn = (TextView) itemView.findViewById(R.id.tutorial_download);
            this.upBtn = (TextView) itemView.findViewById(R.id.tutorial_upload);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.delete_tutorial);
            this.detailsText = (TextView) itemView.findViewById(R.id.tutorial_details);
            this.detailTV = (TextView) itemView.findViewById(R.id.details);
            this.tutDetailsLayout = (LinearLayout) itemView.findViewById(R.id.tut_details_layout);
            this.submittedView = itemView.findViewById(R.id.submitted_view);
            this.uploadCv = (MaterialCardView) itemView.findViewById(R.id.uploadCv);
            this.downloadCv = (MaterialCardView) itemView.findViewById(R.id.downloadCv);
            this.deleteCv = (MaterialCardView) itemView.findViewById(R.id.deleteCv);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            String subject;
            super.onBind(position);
            try {
                Object obj = this.this$0.filteredTutorials.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "filteredTutorials[position]");
                final Tutorial tutorial = (Tutorial) obj;
                Context context = this.itemView.getContext();
                TextView textView = this.sub;
                boolean z = true;
                String str = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) tutorial.getSubject(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null), 1);
                if (str == null || (subject = StringsKt.trim((CharSequence) str).toString()) == null) {
                    subject = tutorial.getSubject();
                }
                textView.setText(subject);
                this.title.setText(tutorial.getTitle());
                this.semester.setText(tutorial.getSemester());
                this.issueDate.setText("Issued: " + this.this$0.orShort(tutorial.getIssuedOn(), HelpFormatter.DEFAULT_LONG_OPT_PREFIX));
                this.lastDate.setText("Due: " + this.this$0.orShort(tutorial.getFinishTime(), HelpFormatter.DEFAULT_LONG_OPT_PREFIX));
                this.detailsText.setText(tutorial.getDetails());
                this.status.setText(tutorial.getStatus());
                if (Intrinsics.areEqual(tutorial.getStatus(), "SUBMITTED")) {
                    this.submittedView.setBackgroundColor(Color.parseColor("#4CAF50"));
                } else {
                    this.submittedView.setBackgroundColor(Color.parseColor("#F44336"));
                }
                this.detailTV.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EvaluationTutorialAdapter.ViewHolder.onBind$lambda$0(this.f$0, view);
                    }
                });
                this.tutDetailsLayout.setVisibility(8);
                this.detailTV.setRotation(90.0f);
                this.isExpanded = false;
                if (Intrinsics.areEqual(tutorial.getStatus(), "SUBMITTED") && Intrinsics.areEqual(tutorial.getType(), ExifInterface.GPS_MEASUREMENT_2D)) {
                    this.deleteBtn.setVisibility(0);
                    this.deleteCv.setVisibility(0);
                } else {
                    this.deleteBtn.setVisibility(8);
                    this.deleteCv.setVisibility(8);
                }
                TextView textView2 = this.deleteBtn;
                final EvaluationTutorialAdapter evaluationTutorialAdapter = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EvaluationTutorialAdapter.ViewHolder.onBind$lambda$1(evaluationTutorialAdapter, tutorial, view);
                    }
                });
                Regex regex = new Regex("[^A-Za-z0-9.]");
                String strReplace = regex.replace(StringsKt.substringAfterLast$default(tutorial.getUrl(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                String strReplace2 = regex.replace(StringsKt.substringAfterLast$default(tutorial.getUploadedFile(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                if (tutorial.getUrl().length() == 0) {
                    this.downBtn.setVisibility(8);
                    this.downloadCv.setVisibility(8);
                } else {
                    this.downBtn.setVisibility(0);
                    this.downloadCv.setVisibility(0);
                    TextView textView3 = this.downBtn;
                    TutorialListener tutorialListener = this.this$0.listener;
                    textView3.setText(tutorialListener != null && tutorialListener.checkFileExistence(strReplace, true) ? "Open" : "Download");
                }
                TextView textView4 = this.downBtn;
                final EvaluationTutorialAdapter evaluationTutorialAdapter2 = this.this$0;
                textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EvaluationTutorialAdapter.ViewHolder.onBind$lambda$2(tutorial, evaluationTutorialAdapter2, position, this, view);
                    }
                });
                if (tutorial.getCanSubmit()) {
                    this.upBtn.setVisibility(0);
                    this.uploadCv.setVisibility(0);
                    if (Intrinsics.areEqual(tutorial.getStatus(), "SUBMITTED")) {
                        if (tutorial.getUploadedFile().length() > 0) {
                            TextView textView5 = this.upBtn;
                            TutorialListener tutorialListener2 = this.this$0.listener;
                            if (tutorialListener2 == null || !tutorialListener2.checkFileExistence(strReplace2, false)) {
                                z = false;
                            }
                            textView5.setText(z ? "Open File" : "View File");
                            this.uploadCv.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
                        } else {
                            this.upBtn.setVisibility(8);
                            this.uploadCv.setVisibility(8);
                        }
                    } else {
                        this.upBtn.setText("Upload");
                        this.uploadCv.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
                    }
                } else {
                    this.upBtn.setVisibility(8);
                    this.uploadCv.setVisibility(8);
                }
                TextView textView6 = this.upBtn;
                final EvaluationTutorialAdapter evaluationTutorialAdapter3 = this.this$0;
                textView6.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter$ViewHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EvaluationTutorialAdapter.ViewHolder.onBind$lambda$3(tutorial, evaluationTutorialAdapter3, this, position, view);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            boolean z = !this$0.isExpanded;
            this$0.isExpanded = z;
            this$0.tutDetailsLayout.setVisibility(z ? 0 : 8);
            this$0.detailTV.setRotation(this$0.isExpanded ? 270.0f : 90.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(EvaluationTutorialAdapter this$0, Tutorial tutorial, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(tutorial, "$tutorial");
            TutorialListener tutorialListener = this$0.listener;
            if (tutorialListener != null) {
                tutorialListener.deleteTutorials(tutorial.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(Tutorial tutorial, EvaluationTutorialAdapter this$0, int i, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(tutorial, "$tutorial");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (tutorial.getCanDownload()) {
                TutorialListener tutorialListener = this$0.listener;
                if (tutorialListener != null) {
                    tutorialListener.downloadFile(tutorial.getUrl(), i, true);
                    return;
                }
                return;
            }
            TextView downBtn = this$1.downBtn;
            Intrinsics.checkNotNullExpressionValue(downBtn, "downBtn");
            ToastExtKt.showInfoToast(downBtn, "Question can download only after Start time");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$3(Tutorial tutorial, EvaluationTutorialAdapter this$0, ViewHolder this$1, int i, View view) {
            Intrinsics.checkNotNullParameter(tutorial, "$tutorial");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!Intrinsics.areEqual(tutorial.getStatus(), "NOT SUBMITTED")) {
                TutorialListener tutorialListener = this$0.listener;
                if (tutorialListener != null) {
                    tutorialListener.downloadFile(tutorial.getUploadedFile(), i, false);
                    return;
                }
                return;
            }
            if (tutorial.getCanSubmit()) {
                TutorialListener tutorialListener2 = this$0.listener;
                if (tutorialListener2 != null) {
                    tutorialListener2.onPickDoc(tutorial.getId());
                    return;
                }
                return;
            }
            TextView upBtn = this$1.upBtn;
            Intrinsics.checkNotNullExpressionValue(upBtn, "upBtn");
            ToastExtKt.showInfoToast(upBtn, "Student can submit tutorial from issued time to the end time.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setIsRecyclable(false);
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Tutorial> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.tutorials.clear();
        ArrayList<Tutorial> arrayList = list;
        this.tutorials.addAll(arrayList);
        this.filteredTutorials.clear();
        this.filteredTutorials.addAll(arrayList);
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void applyCombinedFilter(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "status"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.ArrayList<in.etuwa.app.data.model.tutorial.Tutorial> r0 = r10.filteredTutorials
            r0.clear()
            java.util.ArrayList<in.etuwa.app.data.model.tutorial.Tutorial> r0 = r10.tutorials
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L49
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L29:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L44
            java.lang.Object r3 = r0.next()
            r4 = r3
            in.etuwa.app.data.model.tutorial.Tutorial r4 = (in.etuwa.app.data.model.tutorial.Tutorial) r4
            java.lang.String r4 = r4.getStatus()
            boolean r4 = kotlin.text.StringsKt.equals(r4, r11, r2)
            if (r4 == 0) goto L29
            r1.add(r3)
            goto L29
        L44:
            java.util.List r1 = (java.util.List) r1
            r0 = r1
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        L49:
            r11 = r12
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = kotlin.text.StringsKt.isBlank(r11)
            r11 = r11 ^ r2
            if (r11 == 0) goto Lb4
            java.util.Locale r11 = java.util.Locale.ROOT
            java.lang.String r11 = r12.toLowerCase(r11)
            java.lang.String r12 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L6b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto Laf
            java.lang.Object r3 = r0.next()
            r4 = r3
            in.etuwa.app.data.model.tutorial.Tutorial r4 = (in.etuwa.app.data.model.tutorial.Tutorial) r4
            java.lang.String r5 = r4.getSubject()
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r12)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = r11
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 0
            r8 = 2
            r9 = 0
            boolean r5 = kotlin.text.StringsKt.contains$default(r5, r6, r7, r8, r9)
            if (r5 != 0) goto La8
            java.lang.String r4 = r4.getTitle()
            java.util.Locale r5 = java.util.Locale.ROOT
            java.lang.String r4 = r4.toLowerCase(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r12)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.contains$default(r4, r6, r7, r8, r9)
            if (r4 == 0) goto La9
        La8:
            r7 = 1
        La9:
            if (r7 == 0) goto L6b
            r1.add(r3)
            goto L6b
        Laf:
            java.util.List r1 = (java.util.List) r1
            r0 = r1
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        Lb4:
            java.util.ArrayList<in.etuwa.app.data.model.tutorial.Tutorial> r11 = r10.filteredTutorials
            java.util.Collection r0 = (java.util.Collection) r0
            r11.addAll(r0)
            r10.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.evaluation.EvaluationTutorialAdapter.applyCombinedFilter(java.lang.String, java.lang.String):void");
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setCallBack(EvaluationFragment context) {
        this.listener = context;
    }

    public static /* synthetic */ String orShort$default(EvaluationTutorialAdapter evaluationTutorialAdapter, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
        }
        return evaluationTutorialAdapter.orShort(str, str2);
    }

    public final String orShort(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "default");
        String str3 = str;
        return ((str3 == null || StringsKt.isBlank(str3)) || Intrinsics.areEqual(str, "null")) ? str2 : str;
    }
}