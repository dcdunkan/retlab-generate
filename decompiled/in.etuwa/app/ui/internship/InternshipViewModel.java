package in.etuwa.app.ui.internship;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.internship.InternshipResponse;
import in.etuwa.app.data.repository.InternshipRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternshipViewModel.kt */
/* loaded from: classes5.dex */
public final class InternshipViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final InternshipRepository internshipRepository;
    private MutableLiveData<Resource<InternshipResponse>> internshipResponse;

    public InternshipViewModel(InternshipRepository internshipRepository) {
        Intrinsics.checkNotNullParameter(internshipRepository, "internshipRepository");
        this.internshipRepository = internshipRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.internshipResponse = new MutableLiveData<>();
        getInternship();
    }

    public final void getInternship() {
        this.internshipResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<InternshipResponse> observeOn = this.internshipRepository.getInternshipRequestApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<InternshipResponse, Unit> function1 = new Function1<InternshipResponse, Unit>() { // from class: in.etuwa.app.ui.internship.InternshipViewModel$getInternship$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InternshipResponse internshipResponse) {
                invoke2(internshipResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InternshipResponse internshipResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = InternshipViewModel.this.internshipResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(internshipResponse));
            }
        };
        Consumer<? super InternshipResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.internship.InternshipViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InternshipViewModel.getInternship$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.internship.InternshipViewModel$getInternship$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableLiveData mutableLiveData;
                mutableLiveData = InternshipViewModel.this.internshipResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.internship.InternshipViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InternshipViewModel.getInternship$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getInternship$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getInternship$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<InternshipResponse>> getResponse() {
        return this.internshipResponse;
    }
}