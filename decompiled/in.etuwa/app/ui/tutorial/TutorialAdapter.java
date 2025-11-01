package in.etuwa.app.ui.tutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.tutorial.Tutorial;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.tutorial.TutorialAdapter;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: TutorialAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/tutorial/TutorialAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/tutorial/TutorialAdapter$TutorialListener;", "tutorials", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/tutorial/Tutorial;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/tutorial/TutorialFragment;", "TutorialListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TutorialAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private TutorialListener listener;
    private final ArrayList<Tutorial> tutorials = new ArrayList<>();

    /* compiled from: TutorialAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/tutorial/TutorialAdapter$TutorialListener;", "", "checkFileExistence", "", "fileName", "", "flag", "deleteTutorials", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "onPickDoc", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tutorial, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …_tutorial, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.tutorials.size() > 0) {
            return this.tutorials.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.tutorials.isEmpty() ? 1 : 0;
    }

    /* compiled from: TutorialAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/ui/tutorial/TutorialAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/tutorial/TutorialAdapter;Landroid/view/View;)V", "deleteBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", ErrorBundle.DETAIL_ENTRY, "downBtn", "issueDate", "lastDate", AttendanceDayDialogKt.ARG_SEM, NotificationCompat.CATEGORY_STATUS, "sub", "title", "upBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView deleteBtn;
        private final TextView details;
        private final TextView downBtn;
        private final TextView issueDate;
        private final TextView lastDate;
        private final TextView semester;
        private final TextView status;
        private final TextView sub;
        final /* synthetic */ TutorialAdapter this$0;
        private final TextView title;
        private final TextView upBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(TutorialAdapter tutorialAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = tutorialAdapter;
            this.sub = (TextView) itemView.findViewById(R.id.tutorial_name);
            this.semester = (TextView) itemView.findViewById(R.id.tutorial_sem);
            this.title = (TextView) itemView.findViewById(R.id.tutorial_title);
            this.details = (TextView) itemView.findViewById(R.id.tutorial_details);
            this.issueDate = (TextView) itemView.findViewById(R.id.tutorial_issue_date);
            this.lastDate = (TextView) itemView.findViewById(R.id.tutorial_last_date);
            this.status = (TextView) itemView.findViewById(R.id.tutorial_status);
            this.downBtn = (TextView) itemView.findViewById(R.id.tutorial_download);
            this.upBtn = (TextView) itemView.findViewById(R.id.tutorial_upload);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.delete_tutorial);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.tutorials.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "tutorials[position]");
                final Tutorial tutorial = (Tutorial) obj;
                this.sub.setText(StringsKt.trim((CharSequence) StringsKt.split$default((CharSequence) tutorial.getSubject(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null).get(1)).toString());
                this.semester.setText(tutorial.getSemester());
                this.title.setText(tutorial.getTitle());
                this.issueDate.setText(tutorial.getIssuedOn());
                this.lastDate.setText(tutorial.getFinishTime());
                this.status.setText(tutorial.getStatus());
                this.details.setText("Details : " + tutorial.getDetails());
                if (Intrinsics.areEqual(tutorial.getStatus(), "SUBMITTED") && Intrinsics.areEqual(tutorial.getType(), ExifInterface.GPS_MEASUREMENT_2D)) {
                    this.deleteBtn.setVisibility(0);
                } else {
                    this.deleteBtn.setVisibility(8);
                }
                TextView textView = this.deleteBtn;
                final TutorialAdapter tutorialAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.tutorial.TutorialAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TutorialAdapter.ViewHolder.onBind$lambda$0(TutorialAdapter.this, tutorial, view);
                    }
                });
                Regex regex = new Regex("[^A-Za-z0-9.]");
                String replace = regex.replace(StringsKt.substringAfterLast$default(tutorial.getUrl(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                String replace2 = regex.replace(StringsKt.substringAfterLast$default(tutorial.getUploadedFile(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                if (tutorial.getUrl().length() == 0) {
                    this.downBtn.setVisibility(4);
                } else {
                    this.downBtn.setVisibility(0);
                    TutorialListener tutorialListener = this.this$0.listener;
                    Boolean valueOf = tutorialListener != null ? Boolean.valueOf(tutorialListener.checkFileExistence(replace, true)) : null;
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
                final TutorialAdapter tutorialAdapter2 = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.tutorial.TutorialAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TutorialAdapter.ViewHolder.onBind$lambda$1(Tutorial.this, tutorialAdapter2, position, this, view);
                    }
                });
                if (tutorial.getCanSubmit()) {
                    this.upBtn.setVisibility(0);
                    if (Intrinsics.areEqual(tutorial.getStatus(), "SUBMITTED")) {
                        if (!Intrinsics.areEqual(tutorial.getUploadedFile(), "")) {
                            TutorialListener tutorialListener2 = this.this$0.listener;
                            Boolean valueOf2 = tutorialListener2 != null ? Boolean.valueOf(tutorialListener2.checkFileExistence(replace2, false)) : null;
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
                } else {
                    this.upBtn.setVisibility(4);
                }
                TextView textView3 = this.upBtn;
                final TutorialAdapter tutorialAdapter3 = this.this$0;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.tutorial.TutorialAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TutorialAdapter.ViewHolder.onBind$lambda$2(Tutorial.this, tutorialAdapter3, this, position, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(TutorialAdapter this$0, Tutorial tutorial, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(tutorial, "$tutorial");
            TutorialListener tutorialListener = this$0.listener;
            if (tutorialListener != null) {
                tutorialListener.deleteTutorials(tutorial.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(Tutorial tutorial, TutorialAdapter this$0, int i, ViewHolder this$1, View view) {
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
        public static final void onBind$lambda$2(Tutorial tutorial, TutorialAdapter this$0, ViewHolder this$1, int i, View view) {
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
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Tutorial> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.tutorials.clear();
        this.tutorials.addAll(list);
        notifyDataSetChanged();
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setCallBack(TutorialFragment context) {
        this.listener = context;
    }
}