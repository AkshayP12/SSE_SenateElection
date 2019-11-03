package com.onlinevotingsystem.ovs.validation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import com.onlinevotingsystem.ovs.validation.FieldMatchValidator;

@Constraint(validatedBy = FieldMatchValidator.class)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BallotPaper{
    int [] candidate_Above_vote = NULL;
    String [] candidate_below_vote = NULL;

    Switch(choice)
    {
        case "Above":
            for (int i =0; i<7; i++){

            }
            break; 

        case "Below":
            for (int i =0; i<12; i++){

            }
            break;
    }
}