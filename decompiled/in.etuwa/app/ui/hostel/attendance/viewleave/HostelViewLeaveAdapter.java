package in.etuwa.app.ui.hostel.attendance.viewleave;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.hostel.attendance.HostelAttView;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: HostelViewLeaveAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J \u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001aR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "context", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/attendance/HostelAttView;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveAdapter$CallBack;", "addItems", "", "_list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelViewLeaveAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private final ArrayList<HostelAttView> list = new ArrayList<>();
    private CallBack listener;

    /* compiled from: HostelViewLeaveAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveAdapter$CallBack;", "", "alreadyExitBtnClicked", "", "id", "", "checkFileExistence", "", "fileName", "flag", "delBtnClicked", "downloadFile", "url", CommonCssConstants.POSITION, "", "exitBtnClicked", "viewBtnClicked", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void alreadyExitBtnClicked(String id);

        boolean checkFileExistence(String fileName, boolean flag);

        void delBtnClicked(String id);

        void downloadFile(String url, int position, boolean flag);

        void exitBtnClicked(String id);

        void viewBtnClicked(String id);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view_hostel_attendance, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …ttendance, parent, false)");
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

    /* compiled from: HostelViewLeaveAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/hostel/attendance/viewleave/HostelViewLeaveAdapter;Landroid/view/View;)V", "date", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "delBtn", "Landroid/widget/ImageView;", "downBtn", "exitBtn", "leaveType", "reason", NotificationCompat.CATEGORY_STATUS, "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView date;
        private final ImageView delBtn;
        private final ImageView downBtn;
        private final TextView exitBtn;
        private final TextView leaveType;
        private final TextView reason;
        private final TextView status;
        final /* synthetic */ HostelViewLeaveAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(HostelViewLeaveAdapter hostelViewLeaveAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = hostelViewLeaveAdapter;
            this.leaveType = (TextView) itemView.findViewById(R.id.leave_type_hostel);
            this.status = (TextView) itemView.findViewById(R.id.status_leave);
            this.date = (TextView) itemView.findViewById(R.id.date_leave);
            this.reason = (TextView) itemView.findViewById(R.id.reason_leave);
            this.delBtn = (ImageView) itemView.findViewById(R.id.delete_btn);
            this.downBtn = (ImageView) itemView.findViewById(R.id.download_btn);
            this.exitBtn = (TextView) itemView.findViewById(R.id.exit_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                final HostelAttView hostelAttView = (HostelAttView) obj;
                this.leaveType.setText(hostelAttView.getType());
                this.status.setText(hostelAttView.getStatus());
                this.date.setText(hostelAttView.getDate());
                this.reason.setText(hostelAttView.getReason());
                if (hostelAttView.getBtn_exit()) {
                    this.exitBtn.setVisibility(0);
                    this.exitBtn.setText("Exit");
                    this.exitBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_red);
                } else if (hostelAttView.getBtn_already_exit()) {
                    this.exitBtn.setVisibility(0);
                    this.exitBtn.setText("Exited");
                    this.exitBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_green);
                } else {
                    this.exitBtn.setVisibility(8);
                }
                TextView textView = this.exitBtn;
                if (textView != null) {
                    final HostelViewLeaveAdapter hostelViewLeaveAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HostelViewLeaveAdapter.ViewHolder.onBind$lambda$0(HostelViewLeaveAdapter.ViewHolder.this, hostelViewLeaveAdapter, hostelAttView, view);
                        }
                    });
                }
                String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(hostelAttView.getUrl(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                if (!hostelAttView.getBtn_download()) {
                    this.downBtn.setVisibility(8);
                    if (hostelAttView.getBtn_del()) {
                        this.delBtn.setVisibility(0);
                    } else {
                        this.delBtn.setVisibility(8);
                    }
                } else {
                    this.downBtn.setVisibility(0);
                    if (hostelAttView.getBtn_del()) {
                        this.delBtn.setVisibility(0);
                    } else {
                        this.delBtn.setVisibility(8);
                    }
                    CallBack callBack = this.this$0.listener;
                    Boolean valueOf = callBack != null ? Boolean.valueOf(callBack.checkFileExistence(replace, true)) : null;
                    Intrinsics.checkNotNull(valueOf);
                    if (valueOf.booleanValue()) {
                        this.downBtn.setImageResource(R.drawable.baseline_remove_red_eye_24);
                    } else {
                        this.downBtn.setImageResource(R.drawable.baseline_remove_red_eye_24);
                    }
                }
                ImageView imageView = this.downBtn;
                if (imageView != null) {
                    final HostelViewLeaveAdapter hostelViewLeaveAdapter2 = this.this$0;
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter$ViewHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HostelViewLeaveAdapter.ViewHolder.onBind$lambda$1(HostelViewLeaveAdapter.this, hostelAttView, view);
                        }
                    });
                }
                ImageView imageView2 = this.delBtn;
                if (imageView2 != null) {
                    final HostelViewLeaveAdapter hostelViewLeaveAdapter3 = this.this$0;
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveAdapter$ViewHolder$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HostelViewLeaveAdapter.ViewHolder.onBind$lambda$2(HostelViewLeaveAdapter.this, hostelAttView, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, HostelViewLeaveAdapter this$1, HostelAttView leaveHostel, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(leaveHostel, "$leaveHostel");
            if (Intrinsics.areEqual(this$0.exitBtn.getText().toString(), "Exit")) {
                CallBack callBack = this$1.listener;
                if (callBack != null) {
                    callBack.exitBtnClicked(leaveHostel.getId());
                    return;
                }
                return;
            }
            CallBack callBack2 = this$1.listener;
            if (callBack2 != null) {
                callBack2.alreadyExitBtnClicked(leaveHostel.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(HostelViewLeaveAdapter this$0, HostelAttView leaveHostel, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(leaveHostel, "$leaveHostel");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.viewBtnClicked(leaveHostel.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(HostelViewLeaveAdapter this$0, HostelAttView leaveHostel, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(leaveHostel, "$leaveHostel");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.delBtnClicked(leaveHostel.getId());
            }
        }
    }

    public final void setCallBack(HostelViewLeaveFragment context) {
        this.listener = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<HostelAttView> _list) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        this.list.clear();
        this.list.addAll(_list);
        notifyDataSetChanged();
    }
}