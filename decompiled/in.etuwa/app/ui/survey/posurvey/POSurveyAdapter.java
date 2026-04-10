package in.etuwa.app.ui.survey.posurvey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.survey.posurvey.POSurvey;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.survey.posurvey.POSurveyAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: POSurveyAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class POSurveyAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private SurveyCallBack listener;
    private final ArrayList<POSurvey> surveyList = new ArrayList<>();

    /* JADX INFO: compiled from: POSurveyAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/survey/posurvey/POSurveyAdapter$SurveyCallBack;", "", "doTheSurvey", "", "sessionId", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SurveyCallBack {
        void doTheSurvey(String sessionId);
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_course_survey, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …se_survey, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
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

    /* JADX INFO: compiled from: POSurveyAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/survey/posurvey/POSurveyAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/survey/posurvey/POSurveyAdapter;Landroid/view/View;)V", "lastDate", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_STATUS, "surveyDoBtn", "surveyName", "surveySession", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView lastDate;
        private final TextView status;
        private final TextView surveyDoBtn;
        private final TextView surveyName;
        private final TextView surveySession;
        final /* synthetic */ POSurveyAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(POSurveyAdapter pOSurveyAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = pOSurveyAdapter;
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
                final POSurvey pOSurvey = (POSurvey) obj;
                this.surveyName.setText(pOSurvey.getSurvey());
                this.surveySession.setText(pOSurvey.getSession());
                this.lastDate.setText("Last Date : " + pOSurvey.getEnd_date());
                this.surveyDoBtn.setText(pOSurvey.getBtn());
                this.status.setText(pOSurvey.getStatus());
                TextView textView = this.surveyDoBtn;
                if (textView != null) {
                    final POSurveyAdapter pOSurveyAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.posurvey.POSurveyAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            POSurveyAdapter.ViewHolder.onBind$lambda$0(this.f$0, pOSurveyAdapter, pOSurvey, view);
                        }
                    });
                }
                if (Intrinsics.areEqual(pOSurvey.getStatus(), "Not Completed") && Intrinsics.areEqual(pOSurvey.getBtn(), "Do the survey")) {
                    this.surveyDoBtn.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
                } else if (Intrinsics.areEqual(pOSurvey.getStatus(), " Completed") && Intrinsics.areEqual(pOSurvey.getBtn(), "Completed")) {
                    this.surveyDoBtn.setBackgroundResource(R.drawable.shape_sharp_completed);
                } else {
                    this.surveyDoBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_inactive);
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, POSurveyAdapter this$1, POSurvey surveyList, View view) {
            SurveyCallBack surveyCallBack;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(surveyList, "$surveyList");
            if (!Intrinsics.areEqual(this$0.surveyDoBtn.getText().toString(), "Do the survey") || (surveyCallBack = this$1.listener) == null) {
                return;
            }
            surveyCallBack.doTheSurvey(surveyList.getId());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<POSurvey> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.surveyList.clear();
        this.surveyList.addAll(list);
        notifyDataSetChanged();
    }

    public final void setSurveyCallBack(POSurveyFragment context) {
        this.listener = context;
    }
}