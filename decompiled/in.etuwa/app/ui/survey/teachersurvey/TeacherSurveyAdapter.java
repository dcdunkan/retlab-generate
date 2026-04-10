package in.etuwa.app.ui.survey.teachersurvey;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.survey.TeacherList;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TeacherSurveyAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class TeacherSurveyAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private boolean isAscending;
    private SurveyCallBack listener;
    private final ArrayList<TeacherList> surveyList = new ArrayList<>();
    private final ArrayList<TeacherList> fullList = new ArrayList<>();
    private String currentFilter = "pending";
    private String currentQuery = "";

    /* JADX INFO: compiled from: TeacherSurveyAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyAdapter$SurveyCallBack;", "", "doTheSurvey", "", "teacherId", "", "subjectId", SvgConstants.Tags.IMAGE, AttendanceDayDialogKt.ARG_SEM, "subject", "teacherName", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SurveyCallBack {
        void doTheSurvey(String teacherId, String subjectId, String image, String semester, String subject, String teacherName);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tech_survey, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context)\n   …ch_survey, parent, false)");
            return new ViewHolder(this, viewInflate);
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …mpty_view, parent, false)");
        return new EmptyViewHolder(viewInflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.surveyList.isEmpty()) {
            return this.surveyList.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.surveyList.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: TeacherSurveyAdapter.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J(\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J?\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u000eH\u0014J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u001cH\u0016R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/survey/teachersurvey/TeacherSurveyAdapter;Landroid/view/View;)V", "accentBar", "kotlin.jvm.PlatformType", "statusBadge", "Landroid/widget/TextView;", "surveyDoBtn", "Lcom/google/android/material/button/MaterialButton;", "surveySubName", "surveyTeachName", "applyAccent", "", SvgConstants.Tags.VIEW, "hex", "", "applyBadge", "badge", "text", "bgHex", "textHex", "applyButton", FullDayDialogKt.ARG_BTN, "btnBg", "btnText", "iconRes", "", CommonCssConstants.ENABLED, "", "(Lcom/google/android/material/button/MaterialButton;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V", "clear", "onBind", CommonCssConstants.POSITION, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final View accentBar;
        private final TextView statusBadge;
        private final MaterialButton surveyDoBtn;
        private final TextView surveySubName;
        private final TextView surveyTeachName;
        final /* synthetic */ TeacherSurveyAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(TeacherSurveyAdapter teacherSurveyAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = teacherSurveyAdapter;
            this.surveySubName = (TextView) itemView.findViewById(R.id.sur_teach_sub_name);
            this.surveyTeachName = (TextView) itemView.findViewById(R.id.sur_teach_name);
            this.statusBadge = (TextView) itemView.findViewById(R.id.sur_teach_status_badge);
            this.accentBar = itemView.findViewById(R.id.view_accent_bar);
            this.surveyDoBtn = (MaterialButton) itemView.findViewById(R.id.sur_teach_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.surveyList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "surveyList[position]");
                final TeacherList teacherList = (TeacherList) obj;
                this.surveySubName.setText(teacherList.getSubject());
                this.surveyTeachName.setText(teacherList.getTeacher());
                if (!Intrinsics.areEqual(teacherList.getStatus(), "Not Completed")) {
                    View accentBar = this.accentBar;
                    Intrinsics.checkNotNullExpressionValue(accentBar, "accentBar");
                    applyAccent(accentBar, "#1D9E75");
                    TextView statusBadge = this.statusBadge;
                    Intrinsics.checkNotNullExpressionValue(statusBadge, "statusBadge");
                    applyBadge(statusBadge, "Completed", "#E8F5E9", "#1B5E20");
                    MaterialButton surveyDoBtn = this.surveyDoBtn;
                    Intrinsics.checkNotNullExpressionValue(surveyDoBtn, "surveyDoBtn");
                    applyButton(surveyDoBtn, "Completed", "#E8F5E9", "#1B5E20", Integer.valueOf(R.drawable.ic_check), false);
                } else {
                    View accentBar2 = this.accentBar;
                    Intrinsics.checkNotNullExpressionValue(accentBar2, "accentBar");
                    applyAccent(accentBar2, "#545996");
                    TextView statusBadge2 = this.statusBadge;
                    Intrinsics.checkNotNullExpressionValue(statusBadge2, "statusBadge");
                    applyBadge(statusBadge2, "Pending", "#FAEEDA", "#854F0B");
                    MaterialButton surveyDoBtn2 = this.surveyDoBtn;
                    Intrinsics.checkNotNullExpressionValue(surveyDoBtn2, "surveyDoBtn");
                    applyButton(surveyDoBtn2, "Take Survey", "#545996", "#FFFFFF", Integer.valueOf(R.drawable.ic_survey_check), true);
                    MaterialButton materialButton = this.surveyDoBtn;
                    final TeacherSurveyAdapter teacherSurveyAdapter = this.this$0;
                    materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TeacherSurveyAdapter.ViewHolder.onBind$lambda$0(teacherSurveyAdapter, teacherList, view);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(TeacherSurveyAdapter this$0, TeacherList item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            SurveyCallBack surveyCallBack = this$0.listener;
            if (surveyCallBack != null) {
                surveyCallBack.doTheSurvey(item.getTeacherId(), item.getSubjectId(), item.getImage(), item.getSemester(), item.getSubject(), item.getTeacher());
            }
        }

        private final void applyAccent(View view, String hex) {
            view.setBackgroundColor(Color.parseColor(hex));
        }

        private final void applyBadge(TextView badge, String text, String bgHex, String textHex) {
            badge.setText(text);
            badge.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(bgHex)));
            badge.setTextColor(Color.parseColor(textHex));
        }

        private final void applyButton(MaterialButton btn, String text, String btnBg, String btnText, Integer iconRes, boolean enabled) {
            btn.setText(text);
            btn.setEnabled(enabled);
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(btnBg)));
            btn.setTextColor(Color.parseColor(btnText));
            btn.setIcon(iconRes != null ? ContextCompat.getDrawable(btn.getContext(), iconRes.intValue()) : null);
            btn.setIconTint(ColorStateList.valueOf(Color.parseColor(btnText)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<TeacherList> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.surveyList.clear();
        ArrayList<TeacherList> arrayList = list;
        this.surveyList.addAll(arrayList);
        this.fullList.clear();
        this.fullList.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final void setFilter(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.currentFilter = type;
        applyCombinedFilter$default(this, null, 1, null);
    }

    public static /* synthetic */ void applyCombinedFilter$default(TeacherSurveyAdapter teacherSurveyAdapter, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = teacherSurveyAdapter.currentQuery;
        }
        teacherSurveyAdapter.applyCombinedFilter(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void applyCombinedFilter(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r8.currentQuery = r9
            java.util.ArrayList<in.etuwa.app.data.model.survey.TeacherList> r9 = r8.fullList
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r9 = r9.iterator()
        L16:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L96
            java.lang.Object r1 = r9.next()
            r2 = r1
            in.etuwa.app.data.model.survey.TeacherList r2 = (in.etuwa.app.data.model.survey.TeacherList) r2
            java.lang.String r3 = r2.getStatus()
            java.lang.String r4 = "Not Completed"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            r4 = 1
            r3 = r3 ^ r4
            java.lang.String r5 = r8.currentFilter
            java.lang.String r6 = "completed"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            r7 = 0
            if (r6 == 0) goto L3b
            goto L49
        L3b:
            java.lang.String r6 = "pending"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L48
            if (r3 != 0) goto L46
            goto L48
        L46:
            r3 = 0
            goto L49
        L48:
            r3 = 1
        L49:
            java.lang.String r5 = r2.getSubject()
            if (r5 == 0) goto L5d
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r6 = r8.currentQuery
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r5 = kotlin.text.StringsKt.contains(r5, r6, r4)
            if (r5 != r4) goto L5d
            r5 = 1
            goto L5e
        L5d:
            r5 = 0
        L5e:
            if (r5 != 0) goto L7a
            java.lang.String r2 = r2.getTeacher()
            if (r2 == 0) goto L74
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r5 = r8.currentQuery
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r2 = kotlin.text.StringsKt.contains(r2, r5, r4)
            if (r2 != r4) goto L74
            r2 = 1
            goto L75
        L74:
            r2 = 0
        L75:
            if (r2 == 0) goto L78
            goto L7a
        L78:
            r2 = 0
            goto L7b
        L7a:
            r2 = 1
        L7b:
            if (r3 == 0) goto L8f
            java.lang.String r3 = r8.currentQuery
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L89
            r3 = 1
            goto L8a
        L89:
            r3 = 0
        L8a:
            if (r3 != 0) goto L90
            if (r2 == 0) goto L8f
            goto L90
        L8f:
            r4 = 0
        L90:
            if (r4 == 0) goto L16
            r0.add(r1)
            goto L16
        L96:
            java.util.List r0 = (java.util.List) r0
            boolean r9 = r8.isAscending
            if (r9 == 0) goto Laa
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter$applyCombinedFilter$$inlined$sortedBy$1 r9 = new in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter$applyCombinedFilter$$inlined$sortedBy$1
            r9.<init>()
            java.util.Comparator r9 = (java.util.Comparator) r9
            java.util.List r9 = kotlin.collections.CollectionsKt.sortedWith(r0, r9)
            goto Lb7
        Laa:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter$applyCombinedFilter$$inlined$sortedByDescending$1 r9 = new in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter$applyCombinedFilter$$inlined$sortedByDescending$1
            r9.<init>()
            java.util.Comparator r9 = (java.util.Comparator) r9
            java.util.List r9 = kotlin.collections.CollectionsKt.sortedWith(r0, r9)
        Lb7:
            java.util.ArrayList<in.etuwa.app.data.model.survey.TeacherList> r0 = r8.surveyList
            r0.clear()
            java.util.ArrayList<in.etuwa.app.data.model.survey.TeacherList> r0 = r8.surveyList
            java.util.Collection r9 = (java.util.Collection) r9
            r0.addAll(r9)
            r8.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyAdapter.applyCombinedFilter(java.lang.String):void");
    }

    public final void toggleSort() {
        this.isAscending = !this.isAscending;
        applyCombinedFilter$default(this, null, 1, null);
    }

    public final void setSurveyCallBack(TeacherSurveyFragment context) {
        this.listener = context;
    }
}