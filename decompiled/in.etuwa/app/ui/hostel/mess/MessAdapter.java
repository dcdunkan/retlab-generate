package in.etuwa.app.ui.hostel.mess;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.mess.Mess;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MessAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class MessAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private CallBack listener;
    private final ArrayList<Mess> mess = new ArrayList<>();

    /* JADX INFO: compiled from: MessAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/hostel/mess/MessAdapter$CallBack;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mess, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   ….row_mess, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mess.size() > 0) {
            return this.mess.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.mess.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: MessAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/hostel/mess/MessAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/hostel/mess/MessAdapter;Landroid/view/View;)V", "breakfast", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "dinner", "lunch", "messType", "snacks", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView breakfast;
        private final TextView dinner;
        private final TextView lunch;
        private final TextView messType;
        private final TextView snacks;
        final /* synthetic */ MessAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(MessAdapter messAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = messAdapter;
            this.messType = (TextView) itemView.findViewById(R.id.mess_type);
            this.breakfast = (TextView) itemView.findViewById(R.id.mess_breakfast);
            this.lunch = (TextView) itemView.findViewById(R.id.mess_lunch);
            this.dinner = (TextView) itemView.findViewById(R.id.mess_dinner);
            this.snacks = (TextView) itemView.findViewById(R.id.mess_snacks);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.mess.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "mess[position]");
                Mess mess = (Mess) obj;
                this.messType.setText(mess.getDay());
                int size = mess.getItems().size() - 1;
                if (size < 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (StringsKt.contains$default((CharSequence) mess.getItems().get(i).getType_name(), (CharSequence) "Breakfast", false, 2, (Object) null)) {
                        this.breakfast.setText(mess.getItems().get(i).getMenu());
                    } else if (StringsKt.contains$default((CharSequence) mess.getItems().get(i).getType_name(), (CharSequence) "Lunch", false, 2, (Object) null)) {
                        this.lunch.setText(mess.getItems().get(i).getMenu());
                    } else if (StringsKt.contains$default((CharSequence) mess.getItems().get(i).getType_name(), (CharSequence) "Dinner", false, 2, (Object) null)) {
                        this.dinner.setText(mess.getItems().get(i).getMenu());
                    } else if (StringsKt.contains$default((CharSequence) mess.getItems().get(i).getType_name(), (CharSequence) "Snacks", false, 2, (Object) null)) {
                        this.snacks.setText(mess.getItems().get(i).getMenu());
                    }
                    if (i == size) {
                        return;
                    } else {
                        i++;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Mess> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mess.clear();
        this.mess.addAll(list);
        notifyDataSetChanged();
    }

    public final void setCallBack(MessFragment context) {
        this.listener = context;
    }
}