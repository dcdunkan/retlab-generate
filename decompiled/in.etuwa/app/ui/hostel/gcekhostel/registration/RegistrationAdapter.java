package in.etuwa.app.ui.hostel.gcekhostel.registration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.hostel.gcekhostel.registration.Registration;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: RegistrationAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationAdapter$CallBack;", "registration", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/gcekhostel/registration/Registration;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private CallBack listener;
    private final ArrayList<Registration> registration = new ArrayList<>();

    /* compiled from: RegistrationAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationAdapter$CallBack;", "", "editBtnClicked", "", "id", "", "printCertificate", "url", "viewBtnClicked", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void editBtnClicked(String id);

        void printCertificate(String url);

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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_registration, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …istration, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.registration.size() > 0) {
            return this.registration.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.registration.isEmpty() ? 1 : 0;
    }

    /* compiled from: RegistrationAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationAdapter;Landroid/view/View;)V", "addedAtHr", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "editBtn", "printBtn", "registrationTypeHr", "semName", "statusHr", "viewBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView addedAtHr;
        private final TextView editBtn;
        private final TextView printBtn;
        private final TextView registrationTypeHr;
        private final TextView semName;
        private final TextView statusHr;
        final /* synthetic */ RegistrationAdapter this$0;
        private final TextView viewBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(RegistrationAdapter registrationAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = registrationAdapter;
            this.semName = (TextView) itemView.findViewById(R.id.semester_name_hr);
            this.statusHr = (TextView) itemView.findViewById(R.id.status_hr);
            this.registrationTypeHr = (TextView) itemView.findViewById(R.id.registration_type_hr);
            this.addedAtHr = (TextView) itemView.findViewById(R.id.added_at_hr);
            this.printBtn = (TextView) itemView.findViewById(R.id.print_btn_hr);
            this.viewBtn = (TextView) itemView.findViewById(R.id.view_btn_hr);
            this.editBtn = (TextView) itemView.findViewById(R.id.edit_btn_hr);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.registration.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "registration[position]");
                final Registration registration = (Registration) obj;
                this.semName.setText(registration.getSemester());
                this.statusHr.setText(registration.getStatus());
                this.registrationTypeHr.setText(registration.getReg_type());
                this.addedAtHr.setText(registration.getAdded_at());
                TextView textView = this.printBtn;
                if (textView != null) {
                    final RegistrationAdapter registrationAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RegistrationAdapter.ViewHolder.onBind$lambda$0(Registration.this, registrationAdapter, view);
                        }
                    });
                }
                TextView textView2 = this.viewBtn;
                if (textView2 != null) {
                    final RegistrationAdapter registrationAdapter2 = this.this$0;
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationAdapter$ViewHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RegistrationAdapter.ViewHolder.onBind$lambda$1(RegistrationAdapter.this, registration, view);
                        }
                    });
                }
                String lowerCase = registration.getStatus().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "send back for rectification", false, 2, (Object) null)) {
                    this.editBtn.setVisibility(0);
                } else {
                    this.editBtn.setVisibility(8);
                }
                TextView textView3 = this.editBtn;
                final RegistrationAdapter registrationAdapter3 = this.this$0;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RegistrationAdapter.ViewHolder.onBind$lambda$2(RegistrationAdapter.this, registration, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(Registration registration, RegistrationAdapter this$0, View view) {
            CallBack callBack;
            Intrinsics.checkNotNullParameter(registration, "$registration");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(registration.getPrint(), "") || (callBack = this$0.listener) == null) {
                return;
            }
            callBack.printCertificate(registration.getPrint());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(RegistrationAdapter this$0, Registration registration, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(registration, "$registration");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.viewBtnClicked(registration.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(RegistrationAdapter this$0, Registration registration, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(registration, "$registration");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.editBtnClicked(registration.getId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void addItems(ArrayList<Registration> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.registration.clear();
        this.registration.addAll(list);
        notifyDataSetChanged();
    }

    public final void setCallBack(RegistrationFragment context) {
        this.listener = context;
    }
}