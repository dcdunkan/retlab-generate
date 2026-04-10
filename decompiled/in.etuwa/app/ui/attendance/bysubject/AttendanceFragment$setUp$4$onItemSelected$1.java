package in.etuwa.app.ui.attendance.bysubject;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: AttendanceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@DebugMetadata(c = "in.etuwa.app.ui.attendance.bysubject.AttendanceFragment$setUp$4$onItemSelected$1", f = "AttendanceFragment.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
final class AttendanceFragment$setUp$4$onItemSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AttendanceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AttendanceFragment$setUp$4$onItemSelected$1(AttendanceFragment attendanceFragment, Continuation<? super AttendanceFragment$setUp$4$onItemSelected$1> continuation) {
        super(2, continuation);
        this.this$0 = attendanceFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AttendanceFragment$setUp$4$onItemSelected$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AttendanceFragment$setUp$4$onItemSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.this$0.isLoading) {
                    return Unit.INSTANCE;
                }
                this.this$0.isLoading = true;
                this.this$0.loadSubjectAttendance();
                this.label = 1;
                if (DelayKt.delay(((long) RangesKt.random(new IntRange(200, 500), Random.INSTANCE)) + ((long) RangesKt.random(new IntRange(0, 300), Random.INSTANCE)), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.loadCalendarAttendance();
            this.this$0.isLoading = false;
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.this$0.isLoading = false;
            throw th;
        }
    }
}