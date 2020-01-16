package org.scada_lts.servicebrokers;

import com.serotonin.mango.vo.DataPointVO;
import com.serotonin.mango.vo.event.PointEventDetectorVO;
import org.scada_lts.dao.PointEventDetectorDAO;
import org.scada_lts.dao.model.PointEventDetectorCache;

import java.util.List;

public class ServiceBrokerEventDetectorImpl implements ServiceBrokerEventDetector{

    private PointEventDetectorDAO pointEventDetectorDAO = new PointEventDetectorDAO();

    @Override
    public List<PointEventDetectorCache> getAllEventDetectors() {
        return pointEventDetectorDAO.getAll();
    }

    @Override
    public List<PointEventDetectorVO> getEventDetectorsForGivenDataPointId(DataPointVO dataPointId) {
        return pointEventDetectorDAO.getPointEventDetectors( dataPointId );
    }

    @Override
    public void updateEventDetector(PointEventDetectorVO pointEventDetectorVO) {
        pointEventDetectorDAO.update( pointEventDetectorVO );
    }

    @Override
    public int insertEventDetector(PointEventDetectorVO pointEventDetectorVO) {
        return pointEventDetectorDAO.insert( pointEventDetectorVO );
    }

    @Override
    public void deleteEventDetector(DataPointVO dataPointVO, PointEventDetectorVO pointEventDetectorVO) {
        pointEventDetectorDAO.delete(dataPointVO.getId(), pointEventDetectorVO.getId());
    }
}