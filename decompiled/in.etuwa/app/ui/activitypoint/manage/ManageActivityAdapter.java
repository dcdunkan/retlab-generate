package in.etuwa.app.ui.activitypoint.manage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.activitypoint.manage.ActivityBatch;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.activitypoint.manage.ManageActivityAdapter;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: ManageActivityAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0003J&\u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u000f\u001a\u00020\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/ui/activitypoint/manage/ManageActivityAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "context", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/activitypoint/manage/ActivityBatch;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/activitypoint/manage/ManageActivityAdapter$CallBack;", "addItems", "", "_list", "requireContext", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "Lin/etuwa/app/ui/activitypoint/manage/ManageActivityFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ManageActivityAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private final ArrayList<ActivityBatch> list = new ArrayList<>();
    private CallBack listener;

    /* compiled from: ManageActivityAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/activitypoint/manage/ManageActivityAdapter$CallBack;", "", "onDeleteClick", "", "id", "", "onPickDoc", "onRequestClick", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void onDeleteClick(String id);

        void onPickDoc(String id);

        void onRequestClick(String id);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity_manage, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …ty_manage, parent, false)");
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

    /* compiled from: ManageActivityAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/activitypoint/manage/ManageActivityAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/activitypoint/manage/ManageActivityAdapter;Landroid/view/View;)V", ErrorBundle.DETAIL_ENTRY, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "heading", "manageBtn", "point", "sem", NotificationCompat.CATEGORY_STATUS, "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private TextView details;
        private TextView heading;
        private TextView manageBtn;
        private TextView point;
        private TextView sem;
        private TextView status;
        final /* synthetic */ ManageActivityAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ManageActivityAdapter manageActivityAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = manageActivityAdapter;
            this.heading = (TextView) itemView.findViewById(R.id.manage_activity_name);
            this.sem = (TextView) itemView.findViewById(R.id.manage_activity_sem);
            this.point = (TextView) itemView.findViewById(R.id.manage_activity_point);
            this.details = (TextView) itemView.findViewById(R.id.manage_details);
            this.status = (TextView) itemView.findViewById(R.id.manage_status);
            this.manageBtn = (TextView) itemView.findViewById(R.id.manage_activity_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                final ActivityBatch activityBatch = (ActivityBatch) obj;
                this.heading.setText(activityBatch.getActivityName());
                this.sem.setText(activityBatch.getSemester());
                this.point.setText("Max Point: " + activityBatch.getMaxPoint());
                this.details.setText("Description: " + activityBatch.getDescription());
                this.status.setText("Status: " + activityBatch.getStatus());
                String status = activityBatch.getStatus();
                if (Intrinsics.areEqual(status, "Activity Point Requested")) {
                    this.manageBtn.setText("Delete Request");
                    this.manageBtn.setVisibility(0);
                    this.manageBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_red);
                } else if (Intrinsics.areEqual(status, "Activity Point Not Requested")) {
                    this.manageBtn.setText("Request Activity Point");
                    this.manageBtn.setVisibility(0);
                    this.manageBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_dark);
                } else {
                    this.manageBtn.setVisibility(8);
                }
                TextView textView = this.manageBtn;
                final ManageActivityAdapter manageActivityAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.activitypoint.manage.ManageActivityAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ManageActivityAdapter.ViewHolder.onBind$lambda$0(ActivityBatch.this, manageActivityAdapter, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ActivityBatch activity, ManageActivityAdapter this$0, View view) {
            CallBack callBack;
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(activity.getStatus(), "Activity Point Requested")) {
                CallBack callBack2 = this$0.listener;
                if (callBack2 != null) {
                    callBack2.onDeleteClick(activity.getActivityBatchId());
                    return;
                }
                return;
            }
            if (!Intrinsics.areEqual(activity.getStatus(), "Activity Point Not Requested") || (callBack = this$0.listener) == null) {
                return;
            }
            callBack.onPickDoc(activity.getActivityBatchId());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<ActivityBatch> _list, Context requireContext) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        Intrinsics.checkNotNullParameter(requireContext, "requireContext");
        this.list.clear();
        this.list.addAll(_list);
        this.context = requireContext;
        notifyDataSetChanged();
    }

    public final void setCallBack(ManageActivityFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }
}