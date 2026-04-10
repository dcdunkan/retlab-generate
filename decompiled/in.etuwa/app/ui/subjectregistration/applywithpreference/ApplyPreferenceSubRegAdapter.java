package in.etuwa.app.ui.subjectregistration.applywithpreference;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.subjectregistration.SemSubList;
import in.etuwa.app.data.model.subjectregistration.SubjectMainList;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter;
import in.etuwa.app.utils.CustomEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ApplyPreferenceSubRegAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ApplyPreferenceSubRegAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Integer countss;
    private CallBack listener;
    private final ArrayList<SubjectMainList> subjects = new ArrayList<>();

    /* JADX INFO: compiled from: ApplyPreferenceSubRegAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H&¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegAdapter$CallBack;", "", "onExceedMaxMark", "", "mark", "", CommonCssConstants.POSITION, "", "maxMark", "onSelectSubjectClicked", "onSgpaMarkChanged", "onSubMarkChanged", "spinnerSelected", "id", "dropDownPos", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void onExceedMaxMark(String mark, int position, int maxMark);

        void onSelectSubjectClicked(int position);

        void onSgpaMarkChanged(String mark, int position);

        void onSubMarkChanged(String mark, int position);

        void spinnerSelected(int id, int position, int dropDownPos);
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_apply_preference_sub_reg, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …e_sub_reg, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.subjects.size() > 0) {
            return this.subjects.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.subjects.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: ApplyPreferenceSubRegAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegAdapter;Landroid/view/View;)V", "spinnerSubjects", "Landroid/widget/Spinner;", "kotlin.jvm.PlatformType", "subMarkEt", "Lin/etuwa/app/utils/CustomEditText;", "subject", "Landroid/widget/TextView;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final Spinner spinnerSubjects;
        private final CustomEditText subMarkEt;
        private final TextView subject;
        final /* synthetic */ ApplyPreferenceSubRegAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ApplyPreferenceSubRegAdapter applyPreferenceSubRegAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = applyPreferenceSubRegAdapter;
            this.subject = (TextView) itemView.findViewById(R.id.sub_name_tv);
            this.spinnerSubjects = (Spinner) itemView.findViewById(R.id.spinner_subjects);
            this.subMarkEt = (CustomEditText) itemView.findViewById(R.id.subject_mark);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            int bindingAdapterPosition = getBindingAdapterPosition();
            if (bindingAdapterPosition == -1) {
                return;
            }
            Object obj = this.this$0.subjects.get(bindingAdapterPosition);
            Intrinsics.checkNotNullExpressionValue(obj, "subjects[actualPosition]");
            SubjectMainList subjectMainList = (SubjectMainList) obj;
            ArrayList<SemSubList> subjects = subjectMainList.getSubjects();
            String strReplace$default = StringsKt.replace$default(subjectMainList.getName(), "_", HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR, false, 4, (Object) null);
            if (strReplace$default.length() > 0) {
                char cCharAt = strReplace$default.charAt(0);
                if (Character.isLowerCase(cCharAt)) {
                    cCharAt = Character.toTitleCase(cCharAt);
                }
                String strSubstring = strReplace$default.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                strReplace$default = cCharAt + strSubstring;
            }
            this.subject.setText(strReplace$default);
            if (StringsKt.contains$default((CharSequence) subjectMainList.getName(), (CharSequence) "minor", false, 2, (Object) null)) {
                this.subMarkEt.setHint("(out of 100)");
            } else {
                this.subMarkEt.setHint("(out of 75)");
            }
            List listMutableListOf = CollectionsKt.mutableListOf("Select Subject");
            ArrayList<SemSubList> arrayList = subjects;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((SemSubList) it.next()).getName());
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this.itemView.getContext(), android.R.layout.simple_spinner_item, CollectionsKt.plus((Collection) listMutableListOf, (Iterable) arrayList2));
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spinnerSubjects.setAdapter((SpinnerAdapter) arrayAdapter);
            Iterator<SemSubList> it2 = subjectMainList.getSubjects().iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it2.next().getAns(), "Applied")) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                this.spinnerSubjects.setSelection(i + 1);
            } else {
                this.spinnerSubjects.setSelection(0);
            }
            Spinner spinner = this.spinnerSubjects;
            final ApplyPreferenceSubRegAdapter applyPreferenceSubRegAdapter = this.this$0;
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter$ViewHolder$onBind$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                    Intrinsics.checkNotNullParameter(parent, "parent");
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                    ApplyPreferenceSubRegAdapter.CallBack callBack;
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    if (pos > 0) {
                        int bindingAdapterPosition2 = this.this$0.getBindingAdapterPosition();
                        if (bindingAdapterPosition2 == -1 || (callBack = applyPreferenceSubRegAdapter.listener) == null) {
                            return;
                        }
                        int i2 = pos - 1;
                        callBack.spinnerSelected(((SubjectMainList) applyPreferenceSubRegAdapter.subjects.get(bindingAdapterPosition2)).getSubjects().get(i2).getId(), bindingAdapterPosition2, i2);
                        return;
                    }
                    int bindingAdapterPosition3 = this.this$0.getBindingAdapterPosition();
                    ApplyPreferenceSubRegAdapter.CallBack callBack2 = applyPreferenceSubRegAdapter.listener;
                    if (callBack2 != null) {
                        callBack2.onSelectSubjectClicked(bindingAdapterPosition3);
                    }
                }
            });
            CustomEditText customEditText = this.subMarkEt;
            String mark = ((SubjectMainList) this.this$0.subjects.get(bindingAdapterPosition)).getMark();
            if (mark == null) {
                mark = "";
            }
            customEditText.setText(mark);
            CustomEditText customEditText2 = this.subMarkEt;
            final ApplyPreferenceSubRegAdapter applyPreferenceSubRegAdapter2 = this.this$0;
            customEditText2.addTextChangedListener(new TextWatcher() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter$ViewHolder$onBind$2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String string;
                    if (s == null || (string = s.toString()) == null) {
                        string = "";
                    }
                    int bindingAdapterPosition2 = this.this$0.getBindingAdapterPosition();
                    if (bindingAdapterPosition2 != -1) {
                        try {
                            if (Double.parseDouble(string) > 100.0d && StringsKt.contains$default((CharSequence) this.this$0.subject.getText().toString(), (CharSequence) "Minor", false, 2, (Object) null)) {
                                ApplyPreferenceSubRegAdapter.CallBack callBack = applyPreferenceSubRegAdapter2.listener;
                                if (callBack != null) {
                                    callBack.onExceedMaxMark("0", bindingAdapterPosition2, 100);
                                }
                                this.this$0.subMarkEt.setText("");
                                return;
                            }
                            if (Double.parseDouble(string) > 75.0d && StringsKt.contains$default((CharSequence) this.this$0.subject.getText().toString(), (CharSequence) "Mdc", false, 2, (Object) null)) {
                                ApplyPreferenceSubRegAdapter.CallBack callBack2 = applyPreferenceSubRegAdapter2.listener;
                                if (callBack2 != null) {
                                    callBack2.onExceedMaxMark("0", bindingAdapterPosition2, 75);
                                }
                                this.this$0.subMarkEt.setText("");
                                return;
                            }
                            if (Intrinsics.areEqual(string, "")) {
                                ApplyPreferenceSubRegAdapter.CallBack callBack3 = applyPreferenceSubRegAdapter2.listener;
                                if (callBack3 != null) {
                                    callBack3.onSubMarkChanged("", bindingAdapterPosition2);
                                    return;
                                }
                                return;
                            }
                            ApplyPreferenceSubRegAdapter.CallBack callBack4 = applyPreferenceSubRegAdapter2.listener;
                            if (callBack4 != null) {
                                callBack4.onSubMarkChanged(string, bindingAdapterPosition2);
                            }
                        } catch (NumberFormatException unused) {
                            ApplyPreferenceSubRegAdapter.CallBack callBack5 = applyPreferenceSubRegAdapter2.listener;
                            if (callBack5 != null) {
                                callBack5.onSubMarkChanged("", bindingAdapterPosition2);
                            }
                        }
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    String string;
                    if (s == null || (string = s.toString()) == null) {
                        string = "";
                    }
                    int bindingAdapterPosition2 = this.this$0.getBindingAdapterPosition();
                    if (bindingAdapterPosition2 != -1) {
                        try {
                            if (Double.parseDouble(string) > 100.0d && StringsKt.contains$default((CharSequence) this.this$0.subject.getText().toString(), (CharSequence) "Minor", false, 2, (Object) null)) {
                                ApplyPreferenceSubRegAdapter.CallBack callBack = applyPreferenceSubRegAdapter2.listener;
                                if (callBack != null) {
                                    callBack.onExceedMaxMark("0", bindingAdapterPosition2, 100);
                                }
                                this.this$0.subMarkEt.setText("");
                                return;
                            }
                            if (Double.parseDouble(string) > 75.0d && StringsKt.contains$default((CharSequence) this.this$0.subject.getText().toString(), (CharSequence) "Mdc", false, 2, (Object) null)) {
                                ApplyPreferenceSubRegAdapter.CallBack callBack2 = applyPreferenceSubRegAdapter2.listener;
                                if (callBack2 != null) {
                                    callBack2.onExceedMaxMark("0", bindingAdapterPosition2, 75);
                                }
                                this.this$0.subMarkEt.setText("");
                                return;
                            }
                            if (Intrinsics.areEqual(string, "")) {
                                ApplyPreferenceSubRegAdapter.CallBack callBack3 = applyPreferenceSubRegAdapter2.listener;
                                if (callBack3 != null) {
                                    callBack3.onSubMarkChanged("", bindingAdapterPosition2);
                                    return;
                                }
                                return;
                            }
                            ApplyPreferenceSubRegAdapter.CallBack callBack4 = applyPreferenceSubRegAdapter2.listener;
                            if (callBack4 != null) {
                                callBack4.onSubMarkChanged(string, bindingAdapterPosition2);
                            }
                        } catch (NumberFormatException unused) {
                            ApplyPreferenceSubRegAdapter.CallBack callBack5 = applyPreferenceSubRegAdapter2.listener;
                            if (callBack5 != null) {
                                callBack5.onSubMarkChanged("", bindingAdapterPosition2);
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<SubjectMainList> list, int position) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.subjects.clear();
        this.subjects.addAll(list);
        this.countss = Integer.valueOf(position);
        notifyDataSetChanged();
    }

    public final ArrayList<SubjectMainList> getItems() {
        return this.subjects;
    }

    public final void setCallBack(ApplyPreferenceSubRegDialog context) {
        this.listener = context;
    }
}