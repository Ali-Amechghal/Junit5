
    import com.socgen.itim.fft.dto.Eligibilite;
    import org.springframework.batch.item.ItemProcessor;

    import java.sql.Timestamp;
    import java.util.Date;
    
    public class EligibiliteItemProcessor implements ItemProcessor<Eligibilite, Eligibilite> {

        public static final String OPT_FACTURATION = "27";

        @Override
        public Eligibilite process(final Eligibilite infoTiersDto) throws Exception {
    

            
            Eligibilite eligibilite= Eligibilite.builder()
                    .idTiers(infoTiersDto.getIdTiers())
                    .status(infoTiersDto.getStatus())
                    .topGeneris(OPT_FACTURATION.equalsIgnoreCase(infoTiersDto.getCodeOptFacturation()))
                    .currentDateTime(new Timestamp(new Date().getTime()))
                    .build();
            
            return eligibilite;
        }
    }
