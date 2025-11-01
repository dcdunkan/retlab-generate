package in.etuwa.app.ui.profile.sport;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.profileasiet.sport.Sport;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.profile.sport.SportAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SportAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/ui/profile/sport/SportAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/sport/SportAdapter$SportListener;", "sport", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/profileasiet/sport/Sport;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSportListener", "context", "Lin/etuwa/app/ui/profile/sport/SportFragment;", "SportListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SportAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private SportListener listener;
    private final ArrayList<Sport> sport = new ArrayList<>();

    /* compiled from: SportAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J0\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/profile/sport/SportAdapter$SportListener;", "", "checkFileExistence", "", "fileName", "", "deleteBtnClicked", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "editBtnClicked", "name", "organisedBy", "date", "award", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SportListener {
        boolean checkFileExistence(String fileName);

        void deleteBtnClicked(String id);

        void downloadFile(String url, String position);

        void editBtnClicked(String id, String name, String organisedBy, String date, String award);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sport, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …row_sport, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.sport.size() > 0) {
            return this.sport.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.sport.isEmpty() ? 1 : 0;
    }

    /* compiled from: SportAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lin/etuwa/app/ui/profile/sport/SportAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/profile/sport/SportAdapter;Landroid/view/View;)V", "awardTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "dateTv", "deleteBtn", "editBtn", "eventTv", "eventType", "levelTv", "organizedTv", "title", "viewBtn", "yearTv", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView awardTv;
        private final TextView dateTv;
        private final TextView deleteBtn;
        private final TextView editBtn;
        private final TextView eventTv;
        private final TextView eventType;
        private final TextView levelTv;
        private final TextView organizedTv;
        final /* synthetic */ SportAdapter this$0;
        private final TextView title;
        private final TextView viewBtn;
        private final TextView yearTv;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SportAdapter sportAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = sportAdapter;
            this.title = (TextView) itemView.findViewById(R.id.title_tv);
            this.eventTv = (TextView) itemView.findViewById(R.id.event_tv);
            this.organizedTv = (TextView) itemView.findViewById(R.id.organized_tv);
            this.eventType = (TextView) itemView.findViewById(R.id.event_type);
            this.levelTv = (TextView) itemView.findViewById(R.id.level_tv);
            this.dateTv = (TextView) itemView.findViewById(R.id.date_tv);
            this.yearTv = (TextView) itemView.findViewById(R.id.year_tv);
            this.awardTv = (TextView) itemView.findViewById(R.id.award_tv);
            this.editBtn = (TextView) itemView.findViewById(R.id.edit_btn);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.delete_btn);
            this.viewBtn = (TextView) itemView.findViewById(R.id.view_btn_hr);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.sport.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "sport[position]");
                final Sport sport = (Sport) obj;
                this.title.setText(sport.getName());
                this.eventType.setText(sport.getType());
                this.yearTv.setText(sport.getYear());
                this.eventTv.setText(sport.getEvent());
                this.organizedTv.setText(sport.getOrganized_by());
                this.levelTv.setText(sport.getLevel());
                this.dateTv.setText(sport.getDate());
                this.awardTv.setText(sport.getAwards());
                if (Intrinsics.areEqual(sport.getFile(), "")) {
                    this.viewBtn.setVisibility(4);
                } else {
                    this.viewBtn.setVisibility(0);
                }
                TextView textView = this.viewBtn;
                if (textView != null) {
                    final SportAdapter sportAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.sport.SportAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SportAdapter.ViewHolder.onBind$lambda$0(SportAdapter.this, sport, view);
                        }
                    });
                }
                TextView textView2 = this.editBtn;
                if (textView2 != null) {
                    final SportAdapter sportAdapter2 = this.this$0;
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.sport.SportAdapter$ViewHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SportAdapter.ViewHolder.onBind$lambda$1(SportAdapter.this, sport, view);
                        }
                    });
                }
                TextView textView3 = this.deleteBtn;
                if (textView3 != null) {
                    final SportAdapter sportAdapter3 = this.this$0;
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.sport.SportAdapter$ViewHolder$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SportAdapter.ViewHolder.onBind$lambda$2(SportAdapter.this, sport, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(SportAdapter this$0, Sport sport, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(sport, "$sport");
            SportListener sportListener = this$0.listener;
            if (sportListener != null) {
                sportListener.downloadFile(sport.getFile(), sport.getFile());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(SportAdapter this$0, Sport sport, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(sport, "$sport");
            SportListener sportListener = this$0.listener;
            if (sportListener != null) {
                sportListener.editBtnClicked(sport.getId(), sport.getName(), sport.getOrganized_by(), sport.getDate(), sport.getAwards());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(SportAdapter this$0, Sport sport, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(sport, "$sport");
            SportListener sportListener = this$0.listener;
            if (sportListener != null) {
                sportListener.deleteBtnClicked(sport.getId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Sport> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.sport.clear();
        this.sport.addAll(list);
        notifyDataSetChanged();
    }

    public final void setSportListener(SportFragment context) {
        this.listener = context;
    }
}