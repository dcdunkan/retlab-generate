package in.etuwa.app.ui.survey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.survey.Survey;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.survey.SurveyAdapter;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurveyAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/ui/survey/SurveyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/survey/SurveyAdapter$SurveyCallBack;", "surveyList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/Survey;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSurveyCallBack", "context", "Lin/etuwa/app/ui/survey/SurveyFragment;", "SurveyCallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SurveyAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private SurveyCallBack listener;
    private final ArrayList<Survey> surveyList = new ArrayList<>();

    /* compiled from: SurveyAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/survey/SurveyAdapter$SurveyCallBack;", "", "doTheSurvey", "", "id", "", "type", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SurveyCallBack {
        void doTheSurvey(String id, String type);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_survey, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …ow_survey, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.surveyList.size() > 0) {
            return this.surveyList.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.surveyList.isEmpty() ? 1 : 0;
    }

    /* compiled from: SurveyAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/survey/SurveyAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/survey/SurveyAdapter;Landroid/view/View;)V", "lastDate", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_STATUS, "surveyDoBtn", "surveyName", "surveySession", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView lastDate;
        private final TextView status;
        private final TextView surveyDoBtn;
        private final TextView surveyName;
        private final TextView surveySession;
        final /* synthetic */ SurveyAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SurveyAdapter surveyAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = surveyAdapter;
            this.surveyName = (TextView) itemView.findViewById(R.id.survey_name);
            this.surveySession = (TextView) itemView.findViewById(R.id.survey_session);
            this.lastDate = (TextView) itemView.findViewById(R.id.survey_last_date);
            this.status = (TextView) itemView.findViewById(R.id.survey_status);
            this.surveyDoBtn = (TextView) itemView.findViewById(R.id.survey_do);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.surveyList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "surveyList[position]");
                final Survey survey = (Survey) obj;
                this.surveyName.setText(survey.getName());
                this.surveySession.setText(survey.getSession());
                this.lastDate.setText("Last Date : " + survey.getLastDate());
                String lowerCase = survey.getBtnStatus().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, "last date over")) {
                    if (!survey.getComplete()) {
                        this.status.setText("Not Completed");
                        this.surveyDoBtn.setText("Last Date Over");
                        this.surveyDoBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_inactive);
                    } else {
                        this.status.setText("Completed");
                        this.surveyDoBtn.setText("Last Date Over");
                        this.surveyDoBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_inactive);
                    }
                } else if (!survey.getComplete()) {
                    this.status.setText("Not Completed");
                    this.surveyDoBtn.setText("Do The Survey");
                    this.surveyDoBtn.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
                } else {
                    this.status.setText("Completed");
                    this.surveyDoBtn.setText("Completed");
                    this.surveyDoBtn.setBackgroundResource(R.drawable.shape_sharp_completed);
                }
                TextView textView = this.surveyDoBtn;
                if (textView != null) {
                    final SurveyAdapter surveyAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.SurveyAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SurveyAdapter.ViewHolder.onBind$lambda$0(SurveyAdapter.ViewHolder.this, surveyAdapter, survey, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, SurveyAdapter this$1, Survey surveyList, View view) {
            SurveyCallBack surveyCallBack;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(surveyList, "$surveyList");
            if (!Intrinsics.areEqual(this$0.surveyDoBtn.getText().toString(), "Do The Survey") || (surveyCallBack = this$1.listener) == null) {
                return;
            }
            surveyCallBack.doTheSurvey(surveyList.getSurveyId(), surveyList.getType());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Survey> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.surveyList.clear();
        this.surveyList.addAll(list);
        notifyDataSetChanged();
    }

    public final void setSurveyCallBack(SurveyFragment context) {
        this.listener = context;
    }
}