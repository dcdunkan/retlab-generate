package in.etuwa.app.ui.counselling;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.counselling.Counselling;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.counselling.CounsellingAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CounsellingAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CounsellingAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<Counselling> list = new ArrayList<>();
    private CallBack listener;

    /* JADX INFO: compiled from: CounsellingAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/counselling/CounsellingAdapter$CallBack;", "", "delete", "", "id", "", "editCounselling", "remind", "reopen", "review", "viewCounselling", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void delete(String id);

        void editCounselling(String id);

        void remind(String id);

        void reopen(String id);

        void review(String id);

        void viewCounselling(String id);
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_counselling, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …unselling, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
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

    /* JADX INFO: compiled from: CounsellingAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/ui/counselling/CounsellingAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/counselling/CounsellingAdapter;Landroid/view/View;)V", "date", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "deleteBtn", "editCounsellingBtn", "num", "reminderBtn", "Landroidx/cardview/widget/CardView;", "reminderTxt", "reminderTxt2", "reviewBtn", NotificationCompat.CATEGORY_STATUS, "type", "viewCounsellingBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView date;
        private final TextView deleteBtn;
        private final TextView editCounsellingBtn;
        private final TextView num;
        private final CardView reminderBtn;
        private final TextView reminderTxt;
        private final TextView reminderTxt2;
        private final CardView reviewBtn;
        private final TextView status;
        final /* synthetic */ CounsellingAdapter this$0;
        private final TextView type;
        private final TextView viewCounsellingBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(CounsellingAdapter counsellingAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = counsellingAdapter;
            this.num = (TextView) itemView.findViewById(R.id.cs_number);
            this.type = (TextView) itemView.findViewById(R.id.cs_type);
            this.date = (TextView) itemView.findViewById(R.id.cs_date);
            this.status = (TextView) itemView.findViewById(R.id.cs_status);
            this.reminderBtn = (CardView) itemView.findViewById(R.id.cs_reminder_btn);
            this.reminderTxt2 = (TextView) itemView.findViewById(R.id.cs_reminder_txt2);
            this.reminderTxt = (TextView) itemView.findViewById(R.id.cs_reminder_txt);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.cs_delete);
            this.viewCounsellingBtn = (TextView) itemView.findViewById(R.id.cs_view);
            this.editCounsellingBtn = (TextView) itemView.findViewById(R.id.cs_edit);
            this.reviewBtn = (CardView) itemView.findViewById(R.id.cs_review_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                final Counselling counselling = (Counselling) obj;
                this.num.setText(counselling.getCouncellingNo());
                this.type.setText("Counselling Type : " + counselling.getCouncellingType());
                this.date.setText(counselling.getDate());
                this.status.setText(counselling.getStatus());
                this.reminderTxt2.setText(counselling.getReminder());
                this.reminderTxt.setText(counselling.getReminder());
                if (Intrinsics.areEqual(counselling.getReminder(), "")) {
                    this.reminderTxt.setVisibility(8);
                    this.reminderBtn.setVisibility(8);
                } else if (Intrinsics.areEqual(counselling.getReminder(), "Reopen") || Intrinsics.areEqual(counselling.getReminder(), "Remind")) {
                    this.reminderTxt.setVisibility(8);
                    this.reminderBtn.setVisibility(0);
                } else {
                    this.reminderTxt.setVisibility(0);
                    this.reminderBtn.setVisibility(8);
                }
                if (Intrinsics.areEqual(counselling.getStatus(), "Closed")) {
                    this.reviewBtn.setVisibility(0);
                } else {
                    this.reviewBtn.setVisibility(8);
                }
                TextView textView = this.viewCounsellingBtn;
                final CounsellingAdapter counsellingAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.counselling.CounsellingAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CounsellingAdapter.ViewHolder.onBind$lambda$0(counsellingAdapter, counselling, view);
                    }
                });
                TextView textView2 = this.deleteBtn;
                final CounsellingAdapter counsellingAdapter2 = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.counselling.CounsellingAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CounsellingAdapter.ViewHolder.onBind$lambda$1(counsellingAdapter2, counselling, view);
                    }
                });
                TextView textView3 = this.editCounsellingBtn;
                final CounsellingAdapter counsellingAdapter3 = this.this$0;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.counselling.CounsellingAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CounsellingAdapter.ViewHolder.onBind$lambda$2(counsellingAdapter3, counselling, view);
                    }
                });
                CardView cardView = this.reminderBtn;
                final CounsellingAdapter counsellingAdapter4 = this.this$0;
                cardView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.counselling.CounsellingAdapter$ViewHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CounsellingAdapter.ViewHolder.onBind$lambda$3(counselling, counsellingAdapter4, view);
                    }
                });
                CardView cardView2 = this.reviewBtn;
                final CounsellingAdapter counsellingAdapter5 = this.this$0;
                cardView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.counselling.CounsellingAdapter$ViewHolder$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CounsellingAdapter.ViewHolder.onBind$lambda$4(counsellingAdapter5, counselling, view);
                    }
                });
                String status = counselling.getStatus();
                if (Intrinsics.areEqual(status, "Completed")) {
                    this.status.setTextColor(Color.parseColor("#059669"));
                } else if (Intrinsics.areEqual(status, "Pending")) {
                    this.status.setTextColor(Color.parseColor("#D97706"));
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(CounsellingAdapter this$0, Counselling item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.viewCounselling(item.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(CounsellingAdapter this$0, Counselling item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.delete(item.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(CounsellingAdapter this$0, Counselling item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.editCounselling(item.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$3(Counselling item, CounsellingAdapter this$0, View view) {
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(item.getReminder(), "Remind")) {
                CallBack callBack = this$0.listener;
                if (callBack != null) {
                    callBack.remind(item.getId());
                    return;
                }
                return;
            }
            CallBack callBack2 = this$0.listener;
            if (callBack2 != null) {
                callBack2.reopen(item.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$4(CounsellingAdapter this$0, Counselling item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.review(item.getId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Counselling> _list) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        this.list.clear();
        this.list.addAll(_list);
        notifyDataSetChanged();
    }

    public final void setCallBack(CounsellingFragment context) {
        this.listener = context;
    }
}