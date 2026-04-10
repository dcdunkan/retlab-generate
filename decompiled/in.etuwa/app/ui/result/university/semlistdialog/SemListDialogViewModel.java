package in.etuwa.app.ui.result.university.semlistdialog;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.repository.AttendanceRepository;
import in.etuwa.app.utils.Resource;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SemListDialogViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class SemListDialogViewModel extends ViewModel {
    private final AttendanceRepository attendanceRepository;
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<ArrayList<Semester>>> semResponse;

    public SemListDialogViewModel(AttendanceRepository attendanceRepository) {
        Intrinsics.checkNotNullParameter(attendanceRepository, "attendanceRepository");
        this.attendanceRepository = attendanceRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.semResponse = new MutableLiveData<>();
    }

    public final void getSemester(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getSharedPreferences("app_prefs", 0).getString("semester_list", null);
        if (string != null) {
            Object objFromJson = new Gson().fromJson(string, new TypeToken<ArrayList<Semester>>() { // from class: in.etuwa.app.ui.result.university.semlistdialog.SemListDialogViewModel$getSemester$type$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(objFromJson, "Gson().fromJson(json, type)");
            this.semResponse.postValue(Resource.INSTANCE.success((ArrayList) objFromJson));
            return;
        }
        this.semResponse.postValue(Resource.INSTANCE.error("No cached semester data", null));
    }

    public final MutableLiveData<Resource<ArrayList<Semester>>> getSemResponse() {
        return this.semResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}