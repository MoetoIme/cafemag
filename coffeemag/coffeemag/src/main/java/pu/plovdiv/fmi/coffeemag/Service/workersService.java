package pu.plovdiv.fmi.coffeemag.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pu.plovdiv.fmi.coffeemag.Entity.workers;
import pu.plovdiv.fmi.coffeemag.Repository.workersR;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing worker-related operations.
 */
@Service
public class workersService {

    private final workersR workersR;

    public workersService(workersR workersR) {
        this.workersR = workersR;
    }

    /**
     * Retrieve a list of all workers.
     *
     * @return List of WorkerEntity objects.
     */
    public List<workers> getAllWorkers() {
        return workersR.findAll();
    }

    /**
     * Retrieve a worker by their unique identifier.
     *
     * @param id The unique identifier of the worker.
     * @return WorkerEntity object or null if not found.
     */
    public workers getWorkerById(Long id) {
        Optional<workers> worker = workersR.findById(id);
        return worker.orElse(null);
    }

    /**
     * Create a new worker.
     *
     * @param workerEntity The worker entity to be created.
     * @return Created WorkerEntity object.
     */
    public workers createWorker(workers workerEntity) {
        return workersR.save(workerEntity); // Fix here
    }

    /**
     * Update an existing worker by their unique identifier.
     *
     * @param id          The unique identifier of the worker to be updated.
     * @param workerEntity The updated worker entity.
     * @return Updated WorkerEntity object or null if not found.
     */
    public workers updateWorker(Long id, workers workerEntity) {
        if (workersR.existsById(id)) {
            workerEntity.setId(id); // Ensure we update the correct worker
            return workersR.save(workerEntity);
        } else {
            return null; // Handle not found case
        }
    }

    /**
     * Delete a worker by their unique identifier.
     *
     * @param id The unique identifier of the worker to be deleted.
     */
    public void deleteWorker(Long id) {
        workersR.deleteById(id);
    }

    /**
     * Associate a worker with a department.
     *
     * @param workerId     The unique identifier of the worker.
     * @param departmentId The unique identifier of the department to associate with the worker.
     * @return Updated WorkerEntity object or null if not found.
     */
    public workers associateWorkerWithDepartment(Long workerId, Long departmentId) {
        return workersR.findById(workerId).orElse(null);
    }
}
