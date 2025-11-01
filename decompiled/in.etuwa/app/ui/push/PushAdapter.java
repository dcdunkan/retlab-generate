package in.etuwa.app.ui.push;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.PushModel;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.push.PushAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PushAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eJ\u0016\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001eR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lin/etuwa/app/ui/push/PushAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/PushModel;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/push/PushAdapter$CallBack;", "addItems", "", "msgs", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeAt", "restoreItem", "item", "setCallBack", "context", "Lin/etuwa/app/ui/push/PushActivity;", "setCallBackTwo", "Lin/etuwa/app/ui/push/NotificationActivity;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<PushModel> list = new ArrayList<>();
    private CallBack listener;

    /* compiled from: PushAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/push/PushAdapter$CallBack;", "", "assignments", "", "assignmentsresults", "counselling", "grievance", "homeworks", "internal", "internship", "material", "moduletest", "moduletestresult", "notice", "seriesexam", "seriesexamresults", "tutorial", "tutorialresult", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void assignments();

        void assignmentsresults();

        void counselling();

        void grievance();

        void homeworks();

        void internal();

        void internship();

        void material();

        void moduletest();

        void moduletestresult();

        void notice();

        void seriesexam();

        void seriesexamresults();

        void tutorial();

        void tutorialresult();
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_push, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   ….row_push, parent, false)");
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

    /* compiled from: PushAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/push/PushAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/push/PushAdapter;Landroid/view/View;)V", "cardview", "Landroidx/cardview/widget/CardView;", "kotlin.jvm.PlatformType", "date", "Landroid/widget/TextView;", "pushMsg", "time", "title", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final CardView cardview;
        private final TextView date;
        private final TextView pushMsg;
        final /* synthetic */ PushAdapter this$0;
        private final TextView time;
        private final TextView title;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PushAdapter pushAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = pushAdapter;
            this.title = (TextView) itemView.findViewById(R.id.push_title);
            this.pushMsg = (TextView) itemView.findViewById(R.id.push_msg);
            this.time = (TextView) itemView.findViewById(R.id.push_time);
            this.date = (TextView) itemView.findViewById(R.id.push_date);
            this.cardview = (CardView) itemView.findViewById(R.id.push_cardview);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                final PushModel pushModel = (PushModel) obj;
                this.title.setText(pushModel.getTitle());
                this.pushMsg.setText(pushModel.getMsg());
                String time = pushModel.getTime();
                this.date.setText((CharSequence) StringsKt.split$default((CharSequence) time, new String[]{HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR}, false, 0, 6, (Object) null).get(0));
                this.time.setText((CharSequence) StringsKt.split$default((CharSequence) time, new String[]{HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR}, false, 0, 6, (Object) null).get(1));
                CardView cardView = this.cardview;
                final PushAdapter pushAdapter = this.this$0;
                cardView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.push.PushAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PushAdapter.ViewHolder.onBind$lambda$0(PushModel.this, pushAdapter, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(PushModel msg, PushAdapter this$0, View view) {
            CallBack callBack;
            Intrinsics.checkNotNullParameter(msg, "$msg");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String lowerCase = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "assignment result published", false, 2, (Object) null)) {
                CallBack callBack2 = this$0.listener;
                if (callBack2 != null) {
                    callBack2.assignmentsresults();
                    return;
                }
                return;
            }
            String lowerCase2 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "assignment", false, 2, (Object) null)) {
                CallBack callBack3 = this$0.listener;
                if (callBack3 != null) {
                    callBack3.assignments();
                    return;
                }
                return;
            }
            String lowerCase3 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "series exam result published", false, 2, (Object) null)) {
                CallBack callBack4 = this$0.listener;
                if (callBack4 != null) {
                    callBack4.seriesexamresults();
                    return;
                }
                return;
            }
            String lowerCase4 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) "series", false, 2, (Object) null)) {
                CallBack callBack5 = this$0.listener;
                if (callBack5 != null) {
                    callBack5.seriesexam();
                    return;
                }
                return;
            }
            String lowerCase5 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) "home", false, 2, (Object) null)) {
                CallBack callBack6 = this$0.listener;
                if (callBack6 != null) {
                    callBack6.homeworks();
                    return;
                }
                return;
            }
            String lowerCase6 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase6, (CharSequence) "module exam result published", false, 2, (Object) null)) {
                CallBack callBack7 = this$0.listener;
                if (callBack7 != null) {
                    callBack7.moduletestresult();
                    return;
                }
                return;
            }
            String lowerCase7 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase7, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase7, (CharSequence) "module", false, 2, (Object) null)) {
                CallBack callBack8 = this$0.listener;
                if (callBack8 != null) {
                    callBack8.moduletest();
                    return;
                }
                return;
            }
            String lowerCase8 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase8, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase8, (CharSequence) "material", false, 2, (Object) null)) {
                CallBack callBack9 = this$0.listener;
                if (callBack9 != null) {
                    callBack9.material();
                    return;
                }
                return;
            }
            String lowerCase9 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase9, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase9, (CharSequence) "notice", false, 2, (Object) null)) {
                CallBack callBack10 = this$0.listener;
                if (callBack10 != null) {
                    callBack10.notice();
                    return;
                }
                return;
            }
            String lowerCase10 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase10, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase10, (CharSequence) "tutorial result published", false, 2, (Object) null)) {
                CallBack callBack11 = this$0.listener;
                if (callBack11 != null) {
                    callBack11.tutorialresult();
                    return;
                }
                return;
            }
            String lowerCase11 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase11, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase11, (CharSequence) "tutorial", false, 2, (Object) null)) {
                CallBack callBack12 = this$0.listener;
                if (callBack12 != null) {
                    callBack12.tutorial();
                    return;
                }
                return;
            }
            String lowerCase12 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase12, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase12, (CharSequence) "internal", false, 2, (Object) null)) {
                CallBack callBack13 = this$0.listener;
                if (callBack13 != null) {
                    callBack13.internal();
                    return;
                }
                return;
            }
            String lowerCase13 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase13, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase13, (CharSequence) "grievance", false, 2, (Object) null)) {
                CallBack callBack14 = this$0.listener;
                if (callBack14 != null) {
                    callBack14.grievance();
                    return;
                }
                return;
            }
            String lowerCase14 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase14, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase14, (CharSequence) "counselling", false, 2, (Object) null)) {
                CallBack callBack15 = this$0.listener;
                if (callBack15 != null) {
                    callBack15.counselling();
                    return;
                }
                return;
            }
            String lowerCase15 = msg.getTitle().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase15, "toLowerCase(...)");
            if (!StringsKt.contains$default((CharSequence) lowerCase15, (CharSequence) "internship", false, 2, (Object) null) || (callBack = this$0.listener) == null) {
                return;
            }
            callBack.internship();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<PushModel> msgs) {
        Intrinsics.checkNotNullParameter(msgs, "msgs");
        this.list.clear();
        this.list.addAll(msgs);
        notifyDataSetChanged();
    }

    public final PushModel removeAt(int position) {
        PushModel pushModel = this.list.get(position);
        Intrinsics.checkNotNullExpressionValue(pushModel, "list[position]");
        PushModel pushModel2 = pushModel;
        this.list.remove(position);
        notifyDataSetChanged();
        return pushModel2;
    }

    public final void restoreItem(PushModel item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.list.add(position, item);
        notifyDataSetChanged();
    }

    public final void setCallBack(PushActivity context) {
        this.listener = context;
    }

    public final void setCallBackTwo(NotificationActivity context) {
        this.listener = context;
    }
}