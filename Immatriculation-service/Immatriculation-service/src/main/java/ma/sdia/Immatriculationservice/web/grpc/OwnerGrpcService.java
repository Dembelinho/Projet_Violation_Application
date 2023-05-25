package ma.sdia.Immatriculationservice.web.grpc;

import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import ma.sdia.Immatriculationservice.entities.Owner;
import ma.sdia.Immatriculationservice.repositories.OwnerRepository;
import ma.sdia.Immatriculationservice.web.grpc.stub.OwnerGrpcServiceGrpc;
import ma.sdia.Immatriculationservice.web.grpc.stub.OwnerService;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
@AllArgsConstructor
public class OwnerGrpcService extends OwnerGrpcServiceGrpc.OwnerGrpcServiceImplBase {
    private OwnerRepository ownerRepository;
    @Override
    public void getOwner(OwnerService.GetOwnerRequest request, StreamObserver<OwnerService.GetOwnerResponse> responseObserver) {
        Long ownerId = request.getId();
        Owner owner = ownerRepository.findById(ownerId).orElse(null);
        OwnerService.GetOwnerResponse response;

        if (owner != null) {

            OwnerService.Owner grpcOwner = OwnerService.Owner.newBuilder()
                    .setId(owner.getId())
                    .setName(owner.getName())
                    .setBirthDay(owner.getBirthDay())
                    .setEmail(owner.getEmail())
                    .build();

            response = OwnerService.GetOwnerResponse.newBuilder()
                    .setOwner(grpcOwner)
                    .build();
        } else {
            response = OwnerService.GetOwnerResponse.newBuilder().build(); // Return an empty response or handle the error case
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void listOwners(OwnerService.GetAllOwnersRequest request, StreamObserver<OwnerService.GetAllOwnersResponse> responseObserver) {
        List<Owner> owners = ownerRepository.findAll();

        OwnerService.GetAllOwnersResponse.Builder responseBuilder = OwnerService.GetAllOwnersResponse.newBuilder();
        for (Owner owner : owners) {

            OwnerService.Owner grpcOwner = OwnerService.Owner.newBuilder()
                    .setId(owner.getId())
                    .setName(owner.getName())
                    .setBirthDay(owner.getBirthDay())
                    .setEmail(owner.getEmail())
                    .build();

            responseBuilder.addOwners(grpcOwner);
        }

        OwnerService.GetAllOwnersResponse response = responseBuilder.build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
